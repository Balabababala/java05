package com.example.dao;


import java.util.ArrayList;
import java.util.List;

import com.example.model.Employee;

public class EmployeeDAOMemoryImpl implements EmployeeDAO{

	@Override
	public void add(Employee emp) throws DAOException{
		// TODO Auto-generated method stub
		int id = emp.getId();
		try {
			if(employeeArray[id]!=null) {
				throw new DAOException("編號"+id+"員工已存在 新增失敗");	
			}else {
				employeeArray[emp.getId()] = emp;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new DAOException("編號需小於10");
		}
	}

	@Override
	public void update(Employee emp) throws DAOException{
		// TODO Auto-generated method stub
		int id = emp.getId();
		try {
			if(employeeArray[id]==null) {
				throw new DAOException("編號"+id+"員工未存在 更新失敗");	
			}else {
				employeeArray[emp.getId()] = emp;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new DAOException("編號需小於10");
		}
	}

	@Override
	public void delete(int id) throws DAOException{
		// TODO Auto-generated method stub
		 try {
			 if(employeeArray[id]==null) {
				throw new DAOException("編號"+id+"員工未存在 刪除失敗");	
			}else {
				 employeeArray[id] = null;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new DAOException("編號需小於10");
		}
	}

	@Override
	public Employee findByID(int id) throws DAOException{
		// TODO Auto-generated method stub
		 try {
			 return employeeArray[id];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new DAOException("編號需小於10");
		}
	}

	@Override
	public Employee[] getAllEmployees() throws DAOException{

		// TODO Auto-generated method stub
		List<Employee> emps = new ArrayList<>();
		// Iterate through the memory array and find Employee objects
		for (Employee e : employeeArray) {
			if (e != null) {
		    	emps.add(e);
		    }
		}
		return emps.toArray(new Employee[0]);
		
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		System.out.printf("關閉資源");
	}
	
	
	
	

}
