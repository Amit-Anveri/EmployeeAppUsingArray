package com.capg.empapp.db;

import com.capg.empapp.dto.Employee;

public class EmployeeDB {
	// Employee cannot be resolved to a type
	public static Employee employees[] = new Employee[100];

	public static int count = 0;

	static {

		employees[count++] = new Employee(101, "ramesh", 8, 7000);
		employees[count++] = new Employee(102, "suresh", 2, 8000);
		employees[count++] = new Employee(103, "rakesh", 1, 9000);
		employees[count++] = new Employee(104, "lokesh", 5, 10000);

	}

	public static boolean addEmployee(Employee e) {

		employees[count++] = e;

		return true;
	}

	public static int getCount() {
		return count;
	}

}
