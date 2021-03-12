package com.capg.empapp.main;

import java.util.Scanner;

import com.capg.empapp.db.EmployeeDB;
import com.capg.empapp.dto.Employee;
import com.capg.empapp.execptions.InvalidEmployeeIdExcption;
import com.capg.empapp.service.EmployeeServiceImpl;
import com.capg.empapp.service.IEmployeeService;

public class EmpMainClass {

	IEmployeeService empService = new EmployeeServiceImpl();

	public static void main(String[] args) {

		EmpMainClass app = new EmpMainClass();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println(" === MENU ==== ");
			System.out.println("1. add employee ");
			System.out.println("2. Display All Employee ");
			System.out.println("3. Edit employee salary by id");
			System.out.println("4. Edit employee expirience by id");
			System.out.println("5. Get employee with salary");
			System.out.println("6. Get employee with salary range");
			System.out.println("0. EXIT");
			System.out.println("Enter Option");
			int option = Integer.parseInt(sc.nextLine());
			switch (option) {

			case 1:

				System.out.println("Enter Employee Id ");
				int empId = Integer.parseInt(sc.nextLine());

				System.out.println("Enter Employee Salary ");
				int empSalary = Integer.parseInt(sc.nextLine());

				System.out.println("Enter Employee Exp ");
				int empExp = Integer.parseInt(sc.nextLine());

				System.out.println("Enter Employee Name ");
				String name = sc.nextLine();

				Employee e = new Employee(empId, name, empExp, empSalary);

				try {
					boolean isInserted = app.empService.addEmployee(e);
					if (isInserted) {
						System.out.println(" Employee Added !!!");
					} else {
						throw new Exception("Cannot added Employee ...");
					}
				} catch (Exception ex) {
					System.out.println(" Contact to Customer Care ... " + ex); // raise the exception
				}

				break;
			case 2:

				Employee arr[] = app.empService.getAllEmployees();
				int count = EmployeeDB.count; // not the code
				System.out.println("  --->>  count in main " + count);
				for (int i = 0; i < count; i++) {
					System.out.println(arr[i]);
					System.out.println(" ========================================================");
				}
				break;
			case 3:
				System.out.println("Enter employee id: ");
				int id = Integer.parseInt(sc.nextLine());
				System.out.println("Enter salary: ");
				int sal = Integer.parseInt(sc.nextLine());
				try {
					boolean isUpdated = app.empService.editSalaryByEmployeeId(id, sal);
					if (isUpdated) {
						System.out.println("Salary updated !!!");
					} else {
						throw new InvalidEmployeeIdExcption();
					}

				} catch (Exception ex) {
					System.out.println(ex);
				}
				break;
			case 4:
				System.out.println("Enter employee id: ");
				int eid = Integer.parseInt(sc.nextLine());
				System.out.println("Enter Expirience: ");
				int exp = Integer.parseInt(sc.nextLine());
				try {
					boolean updated = app.empService.editExpByEmployeeId(eid, exp);

					if (updated) {
						System.out.println("Expirience updated !!!");
					} else {
						throw new InvalidEmployeeIdExcption();
					}
				} catch (Exception ex1) {
					System.out.println("Contact customer care");
				}
				break;
			case 5:
				System.out.println("Enter Salary: ");
				int salary = Integer.parseInt(sc.nextLine());
				Employee[] emps = app.empService.getEmployeeBySalary(salary);
				for (Employee employee : emps) {
					System.out.println(employee);
				}
				break;
			case 6:
				System.out.println("Enter lower salary limit: ");
				int low = Integer.parseInt(sc.nextLine());
				System.out.println("Enter higher salary limit: ");
				int high = Integer.parseInt(sc.nextLine());
				Employee[] emp = app.empService.getEmployessBySalaryRange(low, high);
				for (Employee employee : emp) {
					System.out.println(employee);
				}
				break;

			case 0:
				System.exit(0);
				break;

			}// end switch

		} // end while

	}// end main

}// end class
