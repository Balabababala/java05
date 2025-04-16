package com.example.domain;

public class Admin extends Employee{
	private int hours=8;
	
	
	
	public Admin(String name,String ssn,double salary,Branch branch,int hours) {
		super(name,ssn,salary,branch);
		this.hours=hours;
	}
	
	
	
	
	public double getPay() {
		return getSalary()*hours/160;
	}
	
	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	

}
