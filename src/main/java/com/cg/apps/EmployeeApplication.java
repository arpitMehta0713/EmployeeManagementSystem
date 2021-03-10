package com.cg.apps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cg.apps.ui.*;

@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(EmployeeApplication.class, args);
		EmployeeManagementUI employeeUI = context.getBean(EmployeeManagementUI.class);
		employeeUI.run();

	}

}