package com.example.generics;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ProductCounter {
    // Create a Counting Map
	Map<String, Integer> counts;
    // Create a Name Mapping Map
	Map<String, String> products;
	
    public static void main(String[] args) {

        // List of part data
        String[] parts = new String[]{"1S01", "1S01", "1S01", "1S01", "1S01", "1S02", "1S02", "1S02", "1H01", "1H01", "1S02", "1S01", "1S01", "1H01", "1H01", "1H01", "1S02", "1S02", "1M02", "1M02", "1M02"};

        // Create Product Name Part Number map
        Map<String, String> productNames = new TreeMap<>();
        productNames.put("Blue Polo Shirt", "1S01");
        productNames.put("Black Polo Shirt", "1S02");
        productNames.put("Red Ball Cap", "1H01");
        productNames.put("Duke Mug   ", "1M02");
        
        // Create Product Counter Object and process data
        ProductCounter pc = new ProductCounter(productNames);
        pc.processList(parts);
        pc.printReport();
    }

    public ProductCounter(Map productNames) {
        // Your code here
    	products=productNames;
    	counts=new TreeMap();
    }

    public void processList(String[] list) {
        // your code here

    	for(String item:list) {
    		if(counts.containsKey(item)) {
    			int count=counts.get(item);
    			counts.put(item, ++count);
    		}else {
    			counts.put(item, 1);
    		}
    	}
    }

    private String getProductName(String code) {
        for (Map.Entry<String, String> entry : products.entrySet()) {
            if (entry.getValue().equals(code)) {
                return entry.getKey().trim(); // 去除 "Duke Mug   " 的空白
            }
        }
        return "未知商品";
    }
    
    public void printReport() {
        // Your code here	
    	System.out.printf("==========銷售報告==========%n");
    	for(String name:counts.keySet()) {
    		int count=counts.get(name);
    		String productName = getProductName(name);
    		System.out.printf("%-20s:%5d%n", productName,count);
    	}
    	
    	
    	
    }
}