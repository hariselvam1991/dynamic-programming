package com.techbruiser.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a function 'canConstruct(target, wordBank)' that accepts a target string and an array of strings.
 * 
 * The function should return a boolean indicating whether or not the 'target' can be constructed by 
 * concatenating elements of the 'wordBank' array.
 * 
 * You may reuse elements of 'wordBank' as many times as needed.
 *
 */
public class CanConstruct {

	public static void main(String[] args) {
		
		System.out.println("canConstruct(abcdef, [ab,abc,cd,def,abcd]" + canConstruct("abcdef", new String[]{"ab","abc","cd","def","abcd"}, new HashMap<>()));//true
		System.out.println("canConstruct(skateboard, [bo,rd,ate,t,ska,sk,boar]" + canConstruct("skateboard", new String[]{"bo","rd","ate","t","ska","sk","boar"}, new HashMap<>()));//false
		System.out.println("canConstruct(enterapotentpot, [a,p,ent,enter,ot,o,t]" + canConstruct("enterapotentpot", new String[]{"a","p","ent","enter","ot","o","t"}, new HashMap<>()));//true
		System.out.println("canConstruct(eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef, [e, ee, eee, eeee, eeeee, eeeeee]" + canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}, new HashMap<>()));//false

	}
	
	/**
	 * Approach-1 Without Memorization
	 * @param target
	 * @param wordBank
	 * @return
	 */
	static boolean canConstruct(String target, String[] wordBank) {
		if(target.isEmpty()) {
			return true;
		}
		
		for(String word : wordBank) {
			if(target.startsWith(word)) {
				String suffix = target.substring(word.length());
				if(canConstruct(suffix,wordBank)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Approach-2 With Memorization
	 * @param target
	 * @param wordBank
	 * @param memorization
	 * @return
	 */
	static boolean canConstruct(String target, String[] wordBank, Map<String, Boolean> memorization) {
		if(memorization.containsKey(target)) {
			return memorization.get(target);
		}
		
		if(target.isEmpty()) {
			return true;
		}
		
		for(String word : wordBank) {
			if(target.startsWith(word)) {
				String suffix = target.substring(word.length());
				boolean result = canConstruct(suffix, wordBank, memorization);
				if(result) {
					memorization.put(target, result);
					return true;
				}
			}
		}
		memorization.put(target, false);
		return false;
	}
	
	

}
