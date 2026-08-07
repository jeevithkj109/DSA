package com.dsa.dp.Arrays.RussianDollEnvelopes;

import java.util.Arrays;

/* You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.
 * One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.
 * Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
 * Note: You cannot rotate an envelope.*/

public class Solution {

	public static int maxEnvelopes(int[][] envelopes) {

		if (envelopes == null || envelopes.length == 0)
			return 0;

		// Sort by width ascending, and if widths are equal,
		// sort height descending.
		Arrays.sort(envelopes, (a, b) -> {
			if (a[0] == b[0])
				return Integer.compare(b[1], a[1]);
			return Integer.compare(a[0], b[0]);
		});

		int n = envelopes.length;
		int[] temp = new int[n];
		int size = 0;

		for (int[] envelope : envelopes) {
			int height = envelope[1];

			int index = Arrays.binarySearch(temp, 0, size, height);

			if (index < 0)
				index = -(index + 1);

			temp[index] = height;

			if (index == size)
				size++;
		}

		return size;
	}

	public static void main(String[] args) {
		int[][] envelopes = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };

		System.out.println(maxEnvelopes(envelopes)); // 3
	}
}
