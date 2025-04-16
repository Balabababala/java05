package com.example.domain;

import java.text.NumberFormat;

public abstract class Employee {
	public static int nextId=101;
	private int empId;
	private String name="default";
	private String ssn;
	private double salary=25890;
	private Branch branch;
	protected NumberFormat formatter= NumberFormat.getInstance();
	
	public Employee(String name, String ssn,double salary,Branch branch) {
		this.empId = nextId++;
		this.branch=branch;
		setName(name);
		
		if (ssn.trim().length()!=0 && ssn!=null) {
			this.ssn=ssn;
		}else {
			System.out.printf("好好身分症%n");
		}

		if(salary>=28590) {
			this.salary=salary;
		}else {
			System.out.printf("好好打字%n");
		}
	}
	
	
	
	public Branch getBranch() {
		return branch;
	}
	public int getEmpld() {
		return empId;
	}
	public String getName() {
		return name;
	}
	public String getSsn() {
		return ssn;
	}
	public double getSalary() {
		return salary;
	}
	public void setName(String name) {
		if (name.trim().length()!=0 && name!=null) {
			this.name=name;
		}else {
			System.out.printf("好好打名字%n");
		}
	}
	public void raiseSalary(double increase) {
		if (increase>0) {
			salary+=increase;
		}else {
			System.out.printf("好好打字%n");
		}
		
	}

	public abstract double getPay();

	@Override
	public String toString() {
		return "=========員工資料=======\n"+
				"編號: "+this.getEmpld()+"\n"+
				"名字: "+this.getName()+"\n"+
				"SSN: "+this.getSsn()+"\n"+
				"薪水: "+this.branch.getCurrency()+formatter.format(salary);	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee other = (Employee) obj;
		if (empId != other.empId) {
			return false;
		}
		if (ssn == null) {
			if (other.ssn != null) {
				return false;
			}
		} else if (!ssn.equals(other.ssn)) {
			return false;
		}
		return true;
	}



	
}

