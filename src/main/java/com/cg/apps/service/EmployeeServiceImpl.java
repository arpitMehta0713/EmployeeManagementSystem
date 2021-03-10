package com.cg.apps.service;

import com.cg.apps.beans.*;
import com.cg.apps.dao.*;
import com.cg.apps.exceptions.InvalidDepartmentException;
import com.cg.apps.exceptions.InvalidIdException;
import com.cg.apps.exceptions.InvalidNameException;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private EmployeeDaoImpl empDao;

	@Override
	public Employee add(String name, String department) {
		validateName(name);
		validateDepartment(department);
		Employee employee = new Employee(name, department);
		empDao.add(employee);
		return employee;
	}

	@Override
	public Employee findById(int id) {
		validateId(id);
		return empDao.findById(id);
	}

	@Override
	public void removeById(int id) {
		validateId(id);
		empDao.removeById(id);
	}

	@Override
	public List<Employee> findAll() {
		return empDao.findAll();
	}

	@Override
	public Employee updateName(int id, String name) {
		Employee employee = findById(id);
		employee.setName(name);
		employee = empDao.update(employee);
		return employee;
	}

	void validateId(int id) {
		if (id < 0) {
			throw new InvalidIdException(id + " - Id cannot be negative or 0.");
		}
	}

	void validateName(String name) {
		if (name == null || name.isEmpty() || name.trim().isEmpty()) {
			throw new InvalidNameException(name + " - Name cannot be null or empty.");
		}
		if (name.length() > 10) {
			throw new InvalidNameException(name + " - Name cannot have greater than 10 letters.");
		}
	}

	void validateDepartment(String department) {
		if (department == null || department.isEmpty() || department.trim().isEmpty()) {
			throw new InvalidDepartmentException(department + " - Department name cannot be null or empty.");
		}
	}
}
