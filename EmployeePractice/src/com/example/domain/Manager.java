package com.example.domain;
import java.util.ArrayList;

public class Manager extends Employee implements RegularStaff{
	protected String deptName;
	protected ArrayList<Employee> employees =new ArrayList<>();
	private int baseBonus=100000;
	
	public Manager(String name, String ssn, double salary,Branch branch,String deptName) {
		super(name, ssn, salary,branch);
		this.deptName=deptName;
	}

	
	public String getDeptName() {
		return deptName;
	}

	public boolean addEmployee(Employee employee) {
		if(employees.contains(employee)) {
			System.out.printf("已經有了%n");
			return false;
		}else {
			employees.add(employee);
			return true;
		}
	}
	
	public boolean removeEmployee(Employee employee) {
		if(employees.contains(employee)) {
			employees.remove(employee);
			return true;
		}else {
			System.out.printf("查無此人%n");
			return false;
		}
	}
	public String getStaffDetails() {
		StringBuffer temp = new StringBuffer();
		if(employees.isEmpty()) {
			return " ";
		}else {
			temp.append("管理:"+"\n");
			for(Employee e: employees) {
				temp.append("ID:"+e.getEmpld()+" Name:"+e.getName()+"\n");
			}

		}
		return temp.toString();
	}


	@Override
	public double getPay() {
		return getSalary()+employees.size()*2000;
	}
	@Override
	public String toString() {
		return super.toString()+"\n"+
				"部門: "+deptName+"\n"+getStaffDetails() ;
	}


	@Override
	public double getBonus() {
		return baseBonus * calcPerMultiplier();
	}




}
