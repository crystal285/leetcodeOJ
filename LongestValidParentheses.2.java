//version2: DP dp[i] means the longestValidParentheses ending with index i
public class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n <= 1) return 0;
        int max = 0;
        int[] dp = new int[n];
        
        for(int i = 1; i < n; i++)
        {
            if(s.charAt(i) == '(')
                dp[i] = 0;
            else
            {
                int j = i - dp[i-1] - 1;
                if(j >= 0 && s.charAt(j) == '(')
                {
                    dp[i] = dp[i-1] + 2;
                    if(j >= 1)
                    dp[i] += dp[j-1];
                }
                else
                    dp[i] = 0;
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}