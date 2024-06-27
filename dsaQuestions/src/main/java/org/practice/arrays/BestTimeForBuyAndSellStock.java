package org.practice.arrays;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock
public class BestTimeForBuyAndSellStock {
  public static void main(String[] args) {}

  // Some Glimpses of Kadane's Algorithm
  public int maxProfit(int[] prices) {
    int minStockPrice = prices[0];
    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      int netProfit = prices[i] - minStockPrice;
      maxProfit = max(netProfit, maxProfit);
      minStockPrice = min(minStockPrice, prices[i]);
    }
    return maxProfit;
  }

  private int max(int num1, int num2) {
    return Math.max(num1, num2);
  }

  private int min(int num1, int num2) {
    return Math.min(num1, num2);
  }
}
