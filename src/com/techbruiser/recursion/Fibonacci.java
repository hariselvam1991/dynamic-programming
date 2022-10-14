package com.techbruiser.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a function 'fib(n)' that takes in a number as an argument.
 * The function should return the n-th number of the Fibonacci sequence.
 * 
 * The 1st and 2nd number of the sequence is 1.
 * To generate the next number of the sequence, we sum the previous two.
 * 
 * Example:
 * n	 : 1,2,3,4,5,6,7, 8, 9,...
 * fib(n): 1,1,2,3,5,8,13,21,34,..
 * 
 * if n=7, the fib(7)=13
 * 
 * @author Lenovo-PC
 *
 */
public class Fibonacci {

	public static void main(String[] args) {
		System.out.println("fib(6) " + fib(6));//8
		System.out.println("fib(7) " + fib(7));//13
		System.out.println("fib(8) " + fib(8));//21
		System.out.println("fib(50) " + fib(50));//12586269025
	}
	
	/**
	 * Approach-1 Without Memorization
	 */ 
	 /* static int fib(int n){
		
		if(n <= 2) {
			return 1;
		}else {
			return fib(n-1) + fib(n-2);
		}
	}*/
	
	
	/**
	 * Approach-2 With Memorization
	 */
	static Map<Integer, Long>  memorization = new HashMap<>();
	static Long fib(int n){
		if(memorization.get(n) != null) {
			return memorization.get(n);
		}
		if(n <= 2) {
			return (long) 1;
		}else {
			memorization.put(n, fib(n-1) + fib(n-2));
			return memorization.get(n);
		}
	}

}
