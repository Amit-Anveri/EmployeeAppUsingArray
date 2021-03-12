package com.capg.empapp.dao;

import java.util.Scanner;

import com.capg.empapp.db.EmployeeDB;
import com.capg.empapp.dto.Employee;
import com.capg.empapp.execptions.InvalidEmployeeIdExcption;
import com.capg.empapp.execptions.WrongSalaryException;

public class EmployeeDAOImpl implements IEmployeeDAO {
	Scanner sc = new Scanner(System.in);
	Employee e = new Employee();

	public boolean addEmployee(Employee e) throws WrongSalaryException {
		// SQL insert into employee ......

		// System.out.println(" =====>> DAO Impl employee "+e);
		return EmployeeDB.addEmployee(e);
	}

	public Employee[] getAllEmployees() {

		return EmployeeDB.employees;
	}

	// ============================================================

	public boolean editSalaryByEmployeeId(int id, int salary) throws InvalidEmployeeIdExcption {
		// TODO Auto-generated method stub
		for (Employee e : EmployeeDB.employees) {
			if (e.getEmployeeId() == id) {
				e.setSalary(salary);
				return true;
			}

		}
		return false;
	}

	public boolean editExpByEmployeeId(int id, int exp) throws InvalidEmployeeIdExcption {
		// TODO Auto-generated method stub
		for (Employee e : EmployeeDB.employees) {
			if (e.getEmployeeId() == id) {
				e.setExp(exp);
				return true;
			}

		}
		return false;
	}

	public int noOfSalaryMatch(int salary) {
		int count = 0;
		for (int i = 0; i < EmployeeDB.getCount(); i++) {
			if (EmployeeDB.employees[i].getSalary() == salary)
				count++;

		}
		return count;
	}

	public int noOfSalaryMatchInGivenRange(int salaryLow, int salaryHigh) {
		int count = 0;
		for (int i = 0; i < EmployeeDB.getCount(); i++) {
			e = EmployeeDB.employees[i];
			if (e.getSalary() <= salaryHigh && e.getSalary() >= salaryLow)
				count++;
		}
		return count;
	}

	public Employee[] getEmployeeBySalary(int salary) {
		// TODO Auto-generated method stub
		int no_of_match = noOfSalaryMatch(salary);
		Employee[] emps = new Employee[no_of_match];
		int i = 0;
		for (int j = 0; j < EmployeeDB.getCount(); j++) {
			e = EmployeeDB.employees[j];
			if (e.getSalary() == salary) {
				emps[i++] = EmployeeDB.employees[j];
			}
		}
		return emps;
	}

	public Employee[] getEmployessBySalaryRange(int salaryRangeMin, int salaryRangeMax) {
		int no_Of_Match = noOfSalaryMatchInGivenRange(salaryRangeMin, salaryRangeMax);
		Employee[] emps = new Employee[no_Of_Match];
		int i = 0;
		for (int j = 0; j < EmployeeDB.getCount(); j++) {
			e = EmployeeDB.employees[j];
			if (e.getSalary() <= salaryRangeMax && e.getSalary() >= salaryRangeMin) {
				emps[i++] = EmployeeDB.employees[j];
			}

		}
		return emps;
	}

}
