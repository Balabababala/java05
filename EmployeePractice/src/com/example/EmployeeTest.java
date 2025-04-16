package com.example;

import com.example.domain.*;

public class EmployeeTest {
	public static void main(String args[]) {
		Employee emps[]=new Employee[4];


		emps[0] = new Admin("Admin", "A123456789", 50000 , Branch.Taipei , 123);

		emps[1] = new Engineer ("Engineer", "A123456789",50000, Branch.London);
		((Engineer)emps[1]).addSkill("JAVA");
		((Engineer)emps[1]).addSkill("Android");
		((Engineer)emps[1]).addSkill("JAVA");
		((Engineer)emps[1]).addSkill("Android");
		((Engineer)emps[1]).addSkill("Android");
		((Engineer)emps[1]).addSkill("Android");

		
		emps[2] = new Manager("Manager", "A123456789", 50000, Branch.Paris ,"123");
		((Manager)emps[2]).addEmployee(emps[1]);
		((Manager)emps[2]).addEmployee(emps[1]);
		((Manager)emps[2]).addEmployee(emps[0]);

		emps[3] = new Director("Director", "A123456789", 50000, Branch.Tokyo ,"123",114514);
		((Director)emps[3]).addEmployee(emps[2]);

		for(int i =0; i<emps.length;i++) {
			System.out.printf("%s%n",emps[i]);
			System.out.printf("可領錢錢: %s%n",emps[i].getPay());
			if(emps[i] instanceof RegularStaff) {
				System.out.printf("抽獎: %s%n",RegularStaff.getLuckDraw(emps[i]));
//				System.out.printf("抽獎: %s%n",((RegularStaff)emps[i]).getLuck());
				System.out.printf("年終: %s%n",((RegularStaff)emps[i]).getBonus());
			}
		}
	}
}
