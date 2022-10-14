package com.techbruiser.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a function 'canSum(targetSum, numbers)' that takes in a targetSum and an array of numbers as arguments.
 * 
 * The function should return a boolean indicating whether or not it is possible to generate the targetSum using numbers from the array.
 * 
 * You may use an element of the array as many times as needed.
 * 
 * You may assume that all input numbers are nonnegative.
 * 
 *  
 */
public class CanSum {

	public static void main(String[] args) {
		System.out.println("canSum(7, [2,3]) " + canSum(7, new int[] {2,3}, new HashMap<>()));//true
		System.out.println("canSum(7, [5,3,4,7]) " + canSum(7, new int[] {5,3,4,7}, new HashMap<>()));//true
		System.out.println("canSum(7, [2,4]) " + canSum(7, new int[] {2,4}, new HashMap<>()));//false
		System.out.println("canSum(7, [2,3,5]) " + canSum(7, new int[] {2,3,5}, new HashMap<>()));//true
		System.out.println("canSum(7, [7,14]) " + canSum(7, new int[] {7,14}, new HashMap<>()));//true
		System.out.println("canSum(300, [7,14]) " + canSum(300, new int[] {7,14}, new HashMap<>()));//false
	}
	
	
	/**
	 * Approach-1 Without Memorization
	 */
	 /*static boolean canSum(int targetSum, int[] numbers) {
		if(targetSum == 0) {
			return true;
		}
		if(targetSum < 0) {
			return false;
		}
		for(int i=0;i<numbers.length;i++) {
			int remainderSum = targetSum-numbers[i];
			
			if(canSum(remainderSum, numbers)) {
				return true;
			}
		}
		return false;
	}*/
	
	
	/**
	 * Approach-2 With Memorization
	 */
	static boolean canSum(int targetSum, int[] numbers, Map<Integer, Boolean> memorization) {
		if(memorization.containsKey(targetSum)) {
			return memorization.get(targetSum);
		}
		if(targetSum == 0) {
			return true;
		}
		if(targetSum < 0) {
			return false;
		}
		for(int i=0;i<numbers.length;i++) {
			int remainderSum = targetSum-numbers[i];
			boolean tempResult = canSum(remainderSum, numbers, memorization);
			memorization.put(targetSum, tempResult);
			if(tempResult) {
				return true;
			}
		}
		memorization.put(targetSum, false);
		return false;
	}
	
	

}
