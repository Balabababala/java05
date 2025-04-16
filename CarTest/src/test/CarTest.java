package test;

import java.util.*;


public class CarTest {
	
	static Set brands= new TreeSet() ;
	static List garage= new LinkedList(); 
	
	private static void printCars() {
		System.out.printf("*********************%n");
		System.out.printf("現有品牌:%s%n",brands);
		System.out.printf("現有車輛%s%n",garage);
	}
	
	public static void main(String args[]){
		 
		Scanner sc= new Scanner(System.in); 
		
		String a="";
		while(garage.size()<8) {
			System.out.printf("請輸入品牌名稱:%n");
			String car =sc.nextLine();
			garage.add(car);
			boolean isNewBrand =brands.add(car);
			if(isNewBrand) {
				System.out.printf("新增品牌:%s%n",car);
			}else {
				System.out.printf("已有品牌:%s%n",car);
			}
		}
		printCars();
		System.out.printf("輸入預購品牌:(輸入Quit離開)");
		String want= sc.nextLine();
		while(!want.equalsIgnoreCase("Quit") && !garage.isEmpty()){
			if(brands.contains(want)) {
				int idx = garage.indexOf(want);
				System.out.printf("請至%s車庫%n",idx);
				garage.remove(idx);
				if(!garage.contains(want)) {
					brands.remove(want);
				}
			}else {
				System.out.printf("未銷售%s%n",want);
			}
			System.out.printf("輸入預購品牌:(輸入Quit離開)");
			want= sc.nextLine();
		}
		printCars();
	}
	
}
