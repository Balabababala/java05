package com.example.dao;

import java.io.*;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.example.model.Employee;

public class EmployeeDAOFileImpl implements EmployeeDAO {
	
	private SortedMap<Integer,Employee> employees;	
	SimpleDateFormat df=new SimpleDateFormat("MMM d, yyyy",Locale.US);
	String fileName="";
	
	EmployeeDAOFileImpl(String fileName) {
		this.fileName=fileName;
		employees = new TreeMap<>();
	}
	private void syncData() throws DAOException{
		try (BufferedReader br= new BufferedReader(new FileReader(fileName))){
			employees.clear();
			String line;
			while((line=br.readLine())!=null && line.trim().length()!=0){
				String[] data=line.split("\\|");
				try {
					int id = Integer.parseInt(data[0]);
					String fn=data[1];
					String ln=data[2];
					Date bd = df.parse(data[3]);
					float s=Float.parseFloat(data[4]);
					Employee emp = new Employee(id,fn,ln,bd,s);
					employees.put(id,emp);
				} catch (NumberFormatException | ParseException | ArrayIndexOutOfBoundsException ex) {
					System.err.print("資料錯誤"+line);
				}
			}
		} catch (IOException ex) {
			throw new DAOException("資料讀取錯誤");
		}
	}
	private void commit() throws DAOException{
		try (BufferedWriter pw =new BufferedWriter(new FileWriter(fileName))){
			Set<Integer> index =employees.keySet();
			for(int i: index) {
				Employee emp =employees.get(i);
				String temp=String.format("%d|%s|%s|%s|%.2f%n",
						emp.getId(),
						emp.getFirstName(),emp.getLastName(),
						df.format(emp.getBirthDate()),
						emp.getSalary());
				pw.write(temp);
			}
		} catch (IOException e) {
			throw new DAOException("資料讀取錯誤");
		}
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
			this.commit();
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
			this.commit();
		}

	}

	@Override
	public void delete(int id) throws DAOException {
		// TODO Auto-generated method stub
		if(employees.get(id)==null) {
			throw new DAOException("編號"+id+"員工未存在 刪除失敗");	
		}else {
			employees.remove(id);
			this.commit();
		}
	}

	@Override
	public Employee findByID(int id) throws DAOException {
		// TODO Auto-generated method stub
		this.syncData();
		return employees.get(id);
	}

	@Override
	public Employee[] getAllEmployees() throws DAOException {
		// TODO Auto-generated method stub
		this.syncData();
		return employees.values().toArray(new Employee[0]);
	}


}
