package com.example.domain;

public class Director extends Manager implements RegularStaff{
	private double budget;
	private int baseBonus=500000;
	
	public Director(String name, String ssn, double salary, Branch branch, String deptName,double budget) {
		super(name, ssn, salary,branch,deptName);
		this.budget=budget;
	}
	
	public double getBudget() {
		return budget;
	}
	
	
	
	@Override
	public double getPay() {
		return getSalary()+employees.size()*10000;
	}
	@Override
	public String toString() {
		return  super.toString() +"\n"+
				"預算: "+ budget  ;
	}
	@Override
	public double getBonus() {
		return baseBonus * calcPerMultiplier();
	}
}
