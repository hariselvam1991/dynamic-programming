package com.techbruiser.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Write a function 'countConstruct(target, wordBank)' that accepts a target string and an array of strings.
 * 
 * The function should return number of ways that the 'target' can be constructed by 
 * concatenating elements of the 'wordBank' array.
 * 
 * You may reuse elements of 'wordBank' as many times as needed.
 */
public class CountConstruct {

	public static void main(String[] args) {
		System.out.println("countConstruct(abcdef, [ab,abc,cd,def,abcd]" + countConstruct("abcdef", new String[]{"ab","abc","cd","def","abcd"}, new HashMap<>()));//1
		System.out.println("countConstruct(purple, [purp,p,ur,le,purpl]" + countConstruct("purple", new String[]{"purp","p","ur","le","purpl"}, new HashMap<>()));//2
		System.out.println("countConstruct(skateboard, [bo,rd,ate,t,ska,sk,boar]" + countConstruct("skateboard", new String[]{"bo","rd","ate","t","ska","sk","boar"}, new HashMap<>()));//0
		System.out.println("countConstruct(enterapotentpot, [a,p,ent,enter,ot,o,t]" + countConstruct("enterapotentpot", new String[]{"a","p","ent","enter","ot","o","t"}, new HashMap<>()));//4
		System.out.println("countConstruct(eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef, [e, ee, eee, eeee, eeeee, eeeeee]" + countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
				new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}, new HashMap<>()));//0

	}
	
	/**
	 * Approach-1 Without Memorization
	 */
	/*static int countConstruct(String target, String[] wordBank) {
		
		if(target.isEmpty()) {
			return 1;
		}
		
		int totalCount = 0;
		for(String word : wordBank) {
			
			if(target.startsWith(word)) {
				int numWaysForRest = countConstruct(target.substring(word.length()), wordBank);
				totalCount += numWaysForRest;
			}
			
		}
		
		return totalCount;
	}*/
	
		
	/**
	 * Approach-2 With Memorization
	 * @param target
	 * @param wordBank
	 * @return
	 */
	static int countConstruct(String target, String[] wordBank, Map<String, Integer> memorization) {
		
		if(memorization.containsKey(target)) {
			return memorization.get(target);
		}
		
		
		if(target.isEmpty()) {
			return 1;
		}
		
		int totalCount = 0;
		for(String word : wordBank) {
			
			if(target.startsWith(word)) {
				int numWaysForRest = countConstruct(target.substring(word.length()), wordBank, memorization);
				totalCount += numWaysForRest;
			}	
		}
		memorization.put(target, totalCount);
		return totalCount;
	}

}
