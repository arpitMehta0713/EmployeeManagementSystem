package com.cg.apps.dao;

import com.cg.apps.beans.*;
import java.util.*;

public interface IEmployeeDao {
	void add(Employee employee);

	Employee findById(int id);

	void removeById(int id);

	List<Employee> findAll();

	Employee update(Employee employee);

}
