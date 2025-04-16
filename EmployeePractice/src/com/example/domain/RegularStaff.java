package com.example.domain;
import java.util.Random;


public interface RegularStaff {
	 static String[] gifts= {"1","2","3","4","5","6","7","8","9","10","11"};
	 
	 public double getBonus();
	 
	 public default double calcPerMultiplier(){
		 return (int)((Math.random()*5+1))*0.5;
	 }

//	 public default String getLuck() {
//		 int Ran = new Random().nextInt(gifts.length);
//		 return gifts[Ran];
//	 }
	 
	 public static String getLuckDraw(Object obj) {
		 int Ran = new Random().nextInt(gifts.length);
		 return gifts[Ran];
	 }

}
