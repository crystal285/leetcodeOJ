//dp
public class Solution {

    public int calculateMinimumHP(int[][] dungeon) {

        int m = dungeon.length;

        int n = dungeon[0].length;

        int[][] dp = new int[m][n];

        for(int i = m-1; i >= 0; i--)

            for(int j = n-1; j >= 0; j--)

            {

                if(j + 1 == n && i + 1 == m)

                    dp[i][j] = Math.max(1, 1- dungeon[i][j]);

                else if(j + 1 == n)

                    dp[i][j] = Math.max(1, dp[i+1][j] - dungeon[i][j]);

                else if(i + 1 == m)

                    dp[i][j] = Math.max(1, dp[i][j+1] - dungeon[i][j]);

                else

                    dp[i][j] = Math.max(1, Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j]);

            }

        return dp[0][0];

    }

}
