package com.example.dao;

import com.example.model.Employee;

public interface EmployeeDAO extends AutoCloseable{
    public Employee[] employeeArray = new Employee[10];
	
	public void add(Employee emp) throws DAOException;
	public void update(Employee emp) throws DAOException;
	public void delete(int id) throws DAOException;
	public Employee findByID(int id) throws DAOException;
	public Employee[] getAllEmployees() throws DAOException;
}
