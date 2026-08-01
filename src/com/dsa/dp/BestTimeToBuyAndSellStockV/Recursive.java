package com.dsa.dp.BestTimeToBuyAndSellStockV;

/* You are given an integer array prices where prices[i] is the price of a stock in dollars on the ith day, and an integer k.
 * You are allowed to make at most k transactions, where each transaction can be either of the following:
 * Normal transaction: Buy on day i, then sell on a later day j where i < j. You profit prices[j] - prices[i].
 * Short selling transaction: Sell on day i, then buy back on a later day j where i < j. You profit prices[i] - prices[j].
 * Note that you must complete each transaction before starting another.
 * Additionally, you can't buy or sell on the same day you are selling or buying back as part of a previous transaction.
 * Return the maximum total profit you can earn by making at most k transactions.*/

public class Recursive {
	
	private static int maximumProfit(int index, int buy, int transaction, int n, int[] prices) {
		
		if(transaction == 0) {
			return 0;
		}
		if(index == n) {
			return buy == 1 ? Integer.MIN_VALUE : 0;
			//If buy == 1, and only one stock is present, it will choose the positive value which is already bought, so to avoid it return min_val
		}
		
		//Either choose not to buy on that day, or buy a normal stock or buy a shortsell stock.
		if(buy == 2) {
			return Math.max(maximumProfit(index+1, 2, transaction, n, prices),
					Math.max(-prices[index]+maximumProfit(index+1, 0, transaction, n, prices),
							prices[index]+maximumProfit(index+1, 1, transaction, n, prices)));
		}
		
		//ShortSelling: Either choose to sell or not sell.
		else if(buy == 1) {
			return Math.max(-prices[index]+maximumProfit(index+1, 2, transaction-1, n, prices),
					maximumProfit(index+1, 1, transaction, n, prices));
		}
		
		// Normal Sell: Either choose to sell or not sell
		else {
			return Math.max(prices[index]+maximumProfit(index+1, 2, transaction-1, n, prices),
					maximumProfit(index+1, 0, transaction, n, prices));
		}
	}
	
	public static void main(String[] args) {
		int[] prices = {12,16,19,19,8,1,19,13,9};
		int k = 3;
		
		int n = prices.length;
		
		System.out.println(maximumProfit(0, 2, k, n, prices));
	}
}
