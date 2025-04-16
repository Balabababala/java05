package com.example.dao;

public class EmployeeDAOFactory {
	public EmployeeDAO createEmployeeDAO() throws Exception{
		return new EmployeeDAOJDBCImpl();
	}
}
