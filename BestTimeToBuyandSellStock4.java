public class Solution {
    public int maxProfit(int k, int[] prices) {
    //The local array tracks maximum profit of j transactions & the last transaction is on ith day. The global array tracks the maximum profit of j transactions until ith day.
    int n = prices.length;
    if (n < 2 || k <= 0)
		return 0;
	 if (k >= n / 2) {//pay attention here, k maybe larger than length
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
    int[][] local = new int[n][k+1];
    int[][] global = new int[n][k+1];
    for(int i = 0; i < n; i++)
    {
        local[i][0] = 0;
        global[i][0] = 0;
    }
    for(int i = 1; i < n; i++)
    {
        int diff = prices[i] - prices[i-1];
        for(int j = 1; j <= k; j++)
        {
            local[i][j] = Math.max(global[i-1][j-1] + diff,local[i-1][j] + diff);
            global[i][j] = Math.max(local[i][j], global[i-1][j]);
        }
    }
    return global[n-1][k];
    }
}