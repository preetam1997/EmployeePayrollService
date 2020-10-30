package com.bridgelabz.employeepayroll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollDBService {
	
	private Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "Preetam@1997");
		return con;
	}
	
	public List<EmployeePayrollService> readData() {
		String sql = "Select * from employee_payroll";
		List<EmployeePayrollService> employeePayrollList = new ArrayList<>();
		try {
			Connection connection = this.getConnection();
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeePayrollList;
	}

	

}
