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
		try (Connection connection = this.getConnection()) {

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				double salary = resultSet.getDouble("salary");
				LocalDate date = resultSet.getDate("start").toLocalDate();
				employeePayrollList.add(new Employee(id, name, salary, date));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return employeePayrollList;
	}

	public int updateDataWithNormalStatement(String name, double salary) {
		String sql = String.format("update employee_payroll set salary = %.2f where name = '%s'", salary,name);
		try (Connection connection = this.getConnection()) {
			Statement statement = connection.createStatement();
			return statement.executeUpdate(sql);
			
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

		
	}

	public List<Employee> getEmployeePayrollData(String name) {
		String sql = String.format("select * from employee_payroll where name = '%s'",name);
		List<Employee> employeePayrollList = new ArrayList<>();
		try (Connection connection = this.getConnection()) {

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name_ = resultSet.getString("name");
				double salary = resultSet.getDouble("salary");
				LocalDate date = resultSet.getDate("start").toLocalDate();
				employeePayrollList.add(new Employee(id, name_, salary, date));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return employeePayrollList;
	}
}
