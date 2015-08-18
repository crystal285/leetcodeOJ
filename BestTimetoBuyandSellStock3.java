
//for each divider i,check the sum of max profit of left part and right part.update the maximum
public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int profit = 0;
        int[] left = new int[n];//the max profit from 0 to i
        int[] right = new int[n];//the max profit from i to n
        int min = prices[0];
        int max = prices[n-1];
        left[0] = 0;
        right[n-1] = 0;
        for(int i = 1; i < n; i++)
        {
            min = Math.min(min,prices[i]);
            left[i] = Math.max(left[i-1],prices[i]-min);
        }
        for(int i = n - 2; i >= 0; i--)
        {
            max = Math.max(max,prices[i]);
            right[i] = Math.max(right[i+1],max-prices[i]);
        }
        for(int i = 0; i < n; i++)
        {
            int temp = left[i]+right[i];
            profit = profit > temp ? profit : temp;
        }
        return profit;
    }
}