package com.dsa.dp.Fibonacci;

public class Recursive {
	
	private static int fibonacci(int n) {
		if(n == 0 || n == 1) {
			return n;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	public static void main(String[] args) {
		int n = 3;
		System.out.println(fibonacci(n));
	}
}
