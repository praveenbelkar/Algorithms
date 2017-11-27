package com.algorithm.praveen.divideconquer;

/**
 * Device method to get the maximum profit by buying stocks at lower price and selling stocks at higher price
 *  
 * @author Praveen Belkar
 *
 */
public class MaxProfitStockStrategy {

	public static class StockInfo {
		int profit;
		int buyingDateIndex;
		int sellingDateIndex;
		
		public StockInfo(int profit, int buyingDateIndex, int sellingDateIndex) {
			super();
			this.profit = profit;
			this.buyingDateIndex = buyingDateIndex;
			this.sellingDateIndex = sellingDateIndex;
		}

		@Override
		public String toString() {
			return "StockInfo [profit=" + profit + ", buyingDateIndex=" + buyingDateIndex + ", sellingDateIndex="
					+ sellingDateIndex + "]";
		}
	}

	public int getMinValueIndex(int[] input, int left, int right) {
		int minValue = left;
		for(int i=left; i<=right; i++) {
			if(input[i] < input[minValue]) {
				minValue = i;
			}
		}
		return minValue;
	}
	
	public int getMaxValueIndex(int[] input, int left, int right) {
		int maxValue = left;
		for(int i=left; i<=right; i++) {
			if(input[i] > input[maxValue]) {
				maxValue = i;
			}
		}
		return maxValue;
	}
	
	public StockInfo stockStrategy(int[] input, int left, int right) {
		if(left == right) {
			return new StockInfo(0, left, right);
		} 
		
		int mid = left + (right - left) / 2;
		
		//Get profit from left half
		StockInfo leftProfit = stockStrategy(input, left, mid);
		
		//Get profit from right half
		StockInfo rightProfit = stockStrategy(input, mid+1, right);
		
		//Get profit across both the halves
		int leftMinValueIndex = getMinValueIndex(input, left, mid);
		int rightMaxValueIndex = getMaxValueIndex(input, mid+1, right);
		int profitAcross = input[rightMaxValueIndex] - input[leftMinValueIndex];
		
		if(leftProfit.profit > Math.max(rightProfit.profit, profitAcross)) {
			return leftProfit;
		} else if(rightProfit.profit > Math.max(leftProfit.profit, profitAcross)) {
			return rightProfit;
		} else {
			return new StockInfo(profitAcross, leftMinValueIndex, rightMaxValueIndex);
		}
	}
	
	public static void main(String[] args) {
		int[] input = {10,35,20,65,55,5,85};
		MaxProfitStockStrategy mainObject = new MaxProfitStockStrategy();
		StockInfo result = mainObject.stockStrategy(input, 0, input.length-1);
		System.out.println(result.profit + " " + result.buyingDateIndex + " " + result.sellingDateIndex);
	}
}
