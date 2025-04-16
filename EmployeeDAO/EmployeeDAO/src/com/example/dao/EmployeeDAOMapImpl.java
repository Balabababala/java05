package com.example.dao;

import com.example.model.Employee;
import java.util.*;

public class EmployeeDAOMapImpl implements EmployeeDAO {
	private SortedMap<Integer,Employee> employees; 
	
	public EmployeeDAOMapImpl() {
		employees=new TreeMap<>();
	}
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		System.out.printf("關閉資源");
	}

	@Override
	public void add(Employee emp) throws DAOException {
		// TODO Auto-generated method stub
		int id = emp.getId();
		if(employees.get(id)!=null) {
			throw new DAOException("編號"+id+"員工已存在 新增失敗");	
		}else {
			employees.put(id,emp);
		}
	}

	@Override
	public void update(Employee emp) throws DAOException {
		// TODO Auto-generated method stub
		int id = emp.getId();
		if(employees.get(id)==null) {
			throw new DAOException("編號"+id+"員工未存在 更新失敗");	
		}else {
			employees.put(id,emp);
		}

	}

	@Override
	public void delete(int id) throws DAOException {
		// TODO Auto-generated method stub
		if(employees.get(id)==null) {
			throw new DAOException("編號"+id+"員工未存在 刪除失敗");	
		}else {
			employees.remove(id);
		}
	}

	@Override
	public Employee findByID(int id) throws DAOException {
		// TODO Auto-generated method stub
			 return employees.get(id);
	}

	@Override
	public Employee[] getAllEmployees() throws DAOException {
		// TODO Auto-generated method stub
		return employees.values().toArray(new Employee[0]);
	}

}
