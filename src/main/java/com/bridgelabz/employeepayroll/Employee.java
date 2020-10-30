package com.bridgelabz.employeepayroll;

import java.sql.Date;
import java.time.LocalDate;

public class Employee {
	int id;
	String name;
	String salary;
	LocalDate startDate;
	
	public Employee(int id,String name,String salary,LocalDate startDate) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.startDate = startDate;
	}
}
