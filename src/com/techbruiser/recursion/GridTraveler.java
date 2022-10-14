package com.techbruiser.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * Say that you are a travler on a 2D grid. You begin in the top-left corner and you goal is to travel to the bottom-right corner.
 * You may only move down or right.
 * 
 * In how many ways can you travel to the goal on a grid with dimensions m*n ?
 * 
 * Write a function 'gridTraveler(m,n)' that calculate this.
 *
 */
public class GridTraveler {

	public static void main(String[] args) {
		
		System.out.println("gridTraveler(1,1) " + gridTraveler(1,1));//1
		System.out.println("gridTraveler(2,3) " + gridTraveler(2,3));//3
		System.out.println("gridTraveler(3,2) " + gridTraveler(3,2));//3
		System.out.println("gridTraveler(3,3) " + gridTraveler(3,3));//6
		System.out.println("gridTraveler(18,18) " + gridTraveler(18,18));//2333606220
	}
	
	
	/**
	 * Approach-1 Without Memorization
	 */ 
	/*static int gridTraveler(int m, int n) {
		if(m == 1 && n == 1) {
			return 1;
		}
		
		if(m == 0 || n== 0 ) {
			return 0;
		}
		
		return gridTraveler(m-1, n) + gridTraveler(m, n-1);
		
	}*/
	
	/**
	 * Approach-2 With Memorization
	 */
	static Map<String, Long> memorization = new HashMap<>();
	static Long gridTraveler(int m, int n) {
		String key = m+","+n;
		
		if(memorization.get(key) != null) {
			return memorization.get(key);
		}
		if(m == 1 && n == 1) {
			return (long) 1;
		}
		
		if(m == 0 || n== 0 ) {
			return (long) 0;
		}
		memorization.put(key, gridTraveler(m-1, n) + gridTraveler(m, n-1));
		return memorization.get(key);
		
	}
}
