package caseconversion;
import java.io.*;
import java.lang.reflect.AccessFlag;
import java.util.ArrayList;


public class CaseConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileWriter fw;
		FileReader fr;
		boolean flag=false;
		
		try{
			if(args[1].equals("-U")) {
				flag=true;
			}else if(args[1].equals("-L")) {
				flag=false;
			}else {
				System.out.print("args[1] 沒動到");
			}
			if(args[0]!=null) {
				fw= new FileWriter("result.txt");
				fr= new FileReader(args[0]);
				int i=fr.read();
				while(i!=-1) {
					String input="";
					input+=(char)i;
					if(flag) {
						input=input.toUpperCase();
					}else{
						input=input.toLowerCase();
					}
					fw.write(input);
					i=fr.read();
				}
				fw.close();
				fr.close();
			}
			
		}catch(IOException e) {
			System.err.print("有問題");
		}finally {
			System.out.print("結束");
		}
	}
		
		
}


