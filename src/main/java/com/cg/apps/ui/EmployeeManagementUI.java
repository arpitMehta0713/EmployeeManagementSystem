package com.cg.apps.ui;

import com.cg.apps.beans.*;
import com.cg.apps.exceptions.*;
import com.cg.apps.service.*;
import java.util.*;
import com.cg.apps.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeManagementUI {
	@Autowired
	private EmployeeServiceImpl empService ;

	public static void main(String args[]) {
		EmployeeManagementUI project = new EmployeeManagementUI();
		project.run();
	}

	public void run() {
		try {
			Employee employee1 = empService.add("Arpit", "Developer");
			Employee employee2 = empService.add("Mayur", "Tester");
			Employee employee3 = empService.add("Naman", "Tester");
			Employee employee4 = empService.add("Ankit", "Developer");
			List<Employee> employees = empService.findAll();
			displayAll(employees);
		} catch (InvalidIdException e) {
			System.out.println(e.getMessage());
		} catch (InvalidNameException e) {
			System.out.println(e.getMessage());
		} catch (InvalidDepartmentException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong.");
		}
	}

	public void displayAll(Collection<Employee> employees) {
		System.out.println("!!!!Displaying all employees!!!!");
		for (Employee employee : employees) {
			display(employee);
		}
	}

	public void display(Employee employee) {
		System.out.println(employee.getId() + "-" + employee.getName() + "(" + employee.getDepartment() + ")");
	}
}
