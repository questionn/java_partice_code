//121  买卖股票的最佳时机3
//可以多次买入和卖出的情况，含冷冻期
//使用动态规划思想

public int maxProfit(int[] prices) {
	if (prices == null || prices.length <= 1) {
		return 0;
	}
	//成本
	int[] hold = new int[prices.length];
	//获利
	int[] profit = new int[prices.length];
	hold[0] = -prices[0];
	for (int i = 1; i < prices.length; i++) {
		if (i == 1) {
			hold[i] = Math.max(hold[i - 1], -prices[1]);
		} else {
			hold[i] = Math.max(hold[i - 1], profit[i - 2] - prices[i]);
		}
		profit[i] = Math.max(profit[i - 1], hold[i - 1] + prices[i]);
	}
	return profit[prices.length - 1];   
}
