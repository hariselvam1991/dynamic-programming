package com.techbruiser.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Write a function 'bestSum(targetSum, numbers)' that takes in a targetSum and an array of numbers as arguments.
 * 
 * The function should return an array containing the shortest combination of numbers that add up to exactly targetSum.
 * 
 * If there is a tie for the shortest combination, you may return any one of the shortest.
 * 
 * @author Lenovo-PC
 *
 */
public class BestSum {

	public static void main(String[] args) {
		System.out.println("bestSum(7, [5,3,4,7]" + bestSum(7, Arrays.asList(5,3,4,7), new HashMap<>()));//[7]
		System.out.println("bestSum(8, [2,3,5]" + bestSum(8, Arrays.asList(2,3,5), new HashMap<>()));//[3,5]
		System.out.println("bestSum(8, [1,4,5]" + bestSum(8, Arrays.asList(1,4,5), new HashMap<>()));//[4,4]
		System.out.println("bestSum(100, [1,2,5,25]" + bestSum(100, Arrays.asList(1,2,5,25), new HashMap<>()));//[25,25,25,25] */
	}

	/**
	 * Approach-1 without memorization
	 * @param targetSum
	 * @param numbers
	 * @return
	 */
	/*static List<Integer> bestSum(int targetSum, List<Integer> numbers){
		
		if(targetSum == 0 ) {
			return new ArrayList<>();
		}
		
		if(targetSum < 0) {
			return null;
		}
		
		List<Integer> shortestCombination = null;
		
		for(int number : numbers) {
			int remainderSum = targetSum - number;
			List<Integer> remainderCombination = bestSum(remainderSum, numbers);
			if(remainderCombination !=null) {
				List<Integer> combination = remainderCombination;
				combination.add(number);
				if(shortestCombination==null || (combination.size() < shortestCombination.size())) {
					shortestCombination = combination;
				}
			}
		}
		
		return shortestCombination;
	}*/
	
	/**
	 * Approach-2 With memorization
	 * @param targetSum
	 * @param numbers
	 * @return
	 */
	static List<Integer> bestSum(int targetSum, List<Integer> numbers, Map<Integer, List<Integer>> memorization){
		
		if(memorization.containsKey(targetSum)) {
			return memorization.get(targetSum);
		}
		
		if(targetSum == 0 ) {
			return new ArrayList<>();
		}
		
		if(targetSum < 0) {
			return null;
		}
		
		List<Integer> shortestCombination = new ArrayList<>();
		
		for(int number : numbers) {
			int remainderSum = targetSum - number;
			List<Integer> remainderCombination = bestSum(remainderSum, numbers, memorization);

			if(remainderCombination !=null) {
				List<Integer> combination = new ArrayList<>(remainderCombination) ;
				combination.add(number);
				
				if(shortestCombination.isEmpty() || (combination.size() < shortestCombination.size())) {
					shortestCombination = combination;	
				}
			}
		}
		if(shortestCombination.isEmpty()) {
			memorization.put(targetSum, null);
			return null;
		}
		memorization.put(targetSum, shortestCombination);
		return shortestCombination;
	}
}
