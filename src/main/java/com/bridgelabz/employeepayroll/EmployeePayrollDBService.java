package com.bridgelabz.employeepayroll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollDBService {
	
	public Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AddressBook", "root", "Preetam@1997");
		return con;
	}
	
	public List<Employee> readData() {
		String sql = "Select * from employee_payroll";
		List<Employee> employeePayrollList = new ArrayList<>();
		try {
			Connection connection = this.getConnection();
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String salary = result.getString("salary");
				LocalDate date = result.getDate("start").toLocalDate();
				employeePayrollList.add(new Employee(id,name,salary,date));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeePayrollList;
	}
}
