package com.techbruiser.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Write a function 'allConstruct(target, wordBank)' that accepts a target string and an array of strings.
 * 
 * The function should return a 2D array containing all of the ways that the 'target' can be constructed by concatenating 
 * elements of the 'wordBank' array. Each element of the 2D array should represent one combination that constructs the 'target'.
 * 
 * You may reuse elements of 'wordBank' as many times as needed.
 */
public class AllConstruct {

	public static void main(String[] args) {
		System.out.println("countConstruct(purple, [purp,p,ur,le,purpl] : " + allConstruct("purple", new String[]{"purp","p","ur","le","purpl"}, new HashMap<>()));
		/**
		 * [purp, le], [p, ur, p, le]]
		 */
		
		System.out.println("countConstruct(abcdef, [ab,abc,cd,def,abcd] : " + allConstruct("abcdef", new String[]{"ab","abc","cd","def","abcd","ef","c"}, new HashMap<>()));
		/**
		 * [[ab, cd, ef], [ab, c, def], [abc, def], [abcd, ef]]
		 */
		
		System.out.println("countConstruct(skateboard, [bo,rd,ate,t,ska,sk,boar] : " + allConstruct("skateboard", new String[]{"bo","rd","ate","t","ska","sk","boar"}, new HashMap<>()));//0
		/**
		 * []
		 */
		
		System.out.println("countConstruct(aaaaaaaaaaaaaaaaaaaaaaaaac, [a, aa, aaa, aaaa, aaaaa] : " + allConstruct("aaaaaaaaaaaaaaaaaaaaaaaaac",
				new String[]{"a", "aa", "aaa", "aaaa", "aaaaa"}, new HashMap<>()));
		/**
		 * []
		 */

	}

	/**
	 * Approach-1 Without Memorization
	 */
	/*static List<List<String>> allConstruct(String target, String[] wordBank){
		
		if(target.isEmpty()) {
			List<List<String>> base = new ArrayList<>();
			base.add(new ArrayList<String>());
			return base;
		}
		List<List<String>> allCombinations = new ArrayList<>();

		for(String word : wordBank) {
			if(target.startsWith(word)) {
				List<List<String>> remainderResult = allConstruct(target.substring(word.length()), wordBank);
				 for(int i=0;i<remainderResult.size();i++) {
					 List<String> temp2 = new ArrayList<>(remainderResult.get(i));
					 temp2.add(0, word);
					 allCombinations.add(temp2);
				 }  
			}
		}
		return allCombinations;
	}*/
	
	/**
	 * Approach-2 With Memorization
	 * @param target
	 * @param wordBank
	 * @return
	 */
	static List<List<String>> allConstruct(String target, String[] wordBank, Map<String, List<List<String>>> memorization){
		
		if(memorization.containsKey(target)) {
			return memorization.get(target);
		}
		
		if(target.isEmpty()) {
			List<List<String>> base = new ArrayList<>();
			base.add(new ArrayList<String>()); 
			return base;
		}
		List<List<String>> allCombinations = new ArrayList<>();

		for(String word : wordBank) {
			if(target.startsWith(word)) {
				List<List<String>> remainderResult = allConstruct(target.substring(word.length()), wordBank, memorization);
				 for(int i=0;i<remainderResult.size();i++) {
					 List<String> temp2 = new ArrayList<>(remainderResult.get(i));
					 temp2.add(0, word);
					 allCombinations.add(temp2);
				 }  
			}
		}
		memorization.put(target, allCombinations);
		return allCombinations;
	}
}
