package com.example.domain;
import java.util.Arrays;

public class Engineer extends Employee implements RegularStaff{

	private String[] Skills=new String[5];
	private int skillCount;
	
	
	public Engineer(String name,String ssn,double salary,Branch branch) {
		super(name,ssn,salary,branch);
	}
	
	
	
	public void addSkill(String skill){
		if(skillCount<5) {
			Skills[skillCount++]=skill;
		}else {
			System.out.printf("技能槽已滿%n");
		}
	}


	@Override
	public double getPay() {
		return getSalary()+skillCount*3000;
	}
	
	@Override
	public String toString() {
		String skillStr = Arrays.stream(Skills)
                .filter(s -> s != null)
                .reduce((a, b) -> a + ", " + b)
                .orElse("無技能");
		
		return  super.toString() +"\n"+
				"技能: "+ skillStr  ;
	}



	@Override
	public double getBonus() {
		return getSalary() * calcPerMultiplier();
	}
	
}
