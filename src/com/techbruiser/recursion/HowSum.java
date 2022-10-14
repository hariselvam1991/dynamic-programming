package com.techbruiser.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Write a function 'howSum(targetSum, numbers)' that takes in a targetSum and an array of number as an arguments.
 * 
 * The function should return an array containing any combination of elements that add up to exactly the targetSum. 
 * If there is no combination that adds up to the targetSum, then return null
 * 
 * If there are multiple combination possible, you may return any single one.
 * 
 * @author Lenovo-PC
 *
 */
public class HowSum {

	public static void main(String[] args) {
		System.out.println("howSum(7, [2,3]" + howSum(7, Arrays.asList(2,3), new HashMap<>()));//[3,2,2]
		System.out.println("howSum(7, [5,3,4,7]" + howSum(7, Arrays.asList(5,3,4,7), new HashMap<>()));//[4,3]
		System.out.println("howSum(7, [2,4]" + howSum(7, Arrays.asList(2,4), new HashMap<>()));//null
		System.out.println("howSum(8, [2,3,5]" + howSum(8, Arrays.asList(2,3,5), new HashMap<>()));//[2,2,2,2]
		System.out.println("howSum(300, [7,14]" + howSum(300, Arrays.asList(7,14), new HashMap<>()));//null
	}
	
	/**
	 *  Approach-1 Without Memorization
	 * @param targetSum
	 * @param numbers
	 * @return
	 */
	/*static List<Integer> howSum(int targetSum, List<Integer> numbers) {
		
		if(targetSum == 0) {
			return new ArrayList<>();
		}
		
		if(targetSum < 0) {
			return null;
		}
		
		for(Integer number : numbers) {
			int remainder = targetSum - number;
				List<Integer> remainderResult = howSum(remainder, numbers);
				if(remainderResult != null) {
					remainderResult.add(number);
					return remainderResult;
				}
		}	
		return null;
	}*/
	
	/**
	 *  Approach-2 With Memorization
	 * @param targetSum
	 * @param numbers
	 * @return
	 */
	static List<Integer> howSum(int targetSum, List<Integer> numbers, Map<Integer, List<Integer>> memorization) {
		if(memorization.containsKey(targetSum)) {
			return memorization.get(targetSum);
		}
		
		if(targetSum == 0) {
			return new ArrayList<>();
		}
		
		if(targetSum < 0) {
			return null;
		}
		
		for(Integer number : numbers) {
			int remainder = targetSum - number;
				List<Integer> remainderResult = howSum(remainder, numbers, memorization);
				if(remainderResult != null) {
					remainderResult.add(number);
					memorization.put(targetSum, remainderResult);
					return memorization.get(targetSum);
				} 
		}	
		memorization.put(targetSum, null);
		return null;
	}
	

}
