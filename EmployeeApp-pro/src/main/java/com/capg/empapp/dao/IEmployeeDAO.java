package com.capg.empapp.dao;

import com.capg.empapp.dto.Employee;
import com.capg.empapp.execptions.InvalidEmployeeIdExcption;
import com.capg.empapp.execptions.WrongSalaryException;

public interface IEmployeeDAO {
	
	 public boolean addEmployee(Employee e)throws WrongSalaryException;
	 
	 public boolean editSalaryByEmployeeId(int id, int salary)throws InvalidEmployeeIdExcption;
	 
	 public boolean editExpByEmployeeId(int id, int exp)throws InvalidEmployeeIdExcption;
	 
	 public Employee[] getAllEmployees();
	 
	 public Employee[] getEmployeeBySalary(int salary);
	 
	 public Employee[] getEmployessBySalaryRange(int salaryRangeMin,int salaryRangeMax);

}
