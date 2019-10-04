//121  买卖股票的最佳时机2
//可以多次买入和卖出的情况
//使用动态规划思想

public int maxProfit(int[] prices) {
	int i = 0;
	int valley = prices[0];
	int peak = prices[0];
	int maxprofit = 0;
	while (i < prices.length - 1) {
		while (i < prices.length - 1 && prices[i] >= prices[i + 1])
			i++;
		valley = prices[i];
		while (i < prices.length - 1 && prices[i] <= prices[i + 1])
			i++;
		peak = prices[i];
		maxprofit += peak - valley;
	}
	return maxprofit;
}
