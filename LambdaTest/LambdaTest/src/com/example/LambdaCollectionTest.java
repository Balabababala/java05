package com.example;

import java.util.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

public class LambdaCollectionTest {

    public static void main(String[] args) {
        List<Person> personList = Person.createList();
        
        // 使用 Lambda Expression 定義以LastName來升冪排序   
        System.out.printf("===========以LastName來升冪排序 =============%n");
//        Collections.sort(personList,new LastNameComparator());
        
//        Collections.sort(personList,
//			        	 new Comparator<Person>(){
//        					@Override
//        					public int compare(Person p1, Person p2) {
//			        			return p1.getLastName().compareTo(p2.getLastName());
//			        		}
//        	});
        
        
        Collections.sort(personList,
        				 (p1,p2)->p1.getLastName().compareTo(p2.getLastName()));
        System.out.printf("%s%n",personList.toString());
        // 使用 Lambda Expression 定義以Age來降冪排序  
        System.out.printf("===========以Age來降冪排序 =============%n");
//        Collections.sort(personList,
//				 			(o1,o2)->{if(o1.getAge()>o2.getAge()) {
//				 						return -1;
//				 					 }else if(o1.getAge()<o2.getAge()) {
//				 						return 1;
//				 					 }else 
//				 						return 0;}
//				 		);
        Collections.sort(personList,
        		(p1,p2)->(p2.getAge()+"").compareTo((p1.getAge()+"")));
        System.out.printf("%s%n",personList.toString());
        // 使用 Lambda Expression 定義移除所有女性成員    
        System.out.printf("===========移除所有女性成員  =============%n");
        personList.removeIf(p->p.getGender().equals(Gender.FEMALE));
        System.out.printf("%s%n",personList.toString());
        // 使用 Lambda Expression 定義移除年齡小於35成員  
        System.out.printf("===========移除年齡小於35成員=============%n");
        personList.removeIf(p->p.getAge()<35);
        System.out.printf("%s%n",personList.toString());
    }
}