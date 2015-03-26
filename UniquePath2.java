public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;

        int n = obstacleGrid[0].length;

        if(m == 0 || n == 0)

            return 0;

        if(obstacleGrid[m-1][n-1] == 1) //pay attention to this case

            return 0;

        int[][] way = new int[m][n];

        way[0][0] = 1;

        for(int i = 0; i < m; i++)

            for(int j = 0; j < n; j++)

            {

                if((i-1) >= 0 && obstacleGrid[i-1][j] == 0)

                {

                    way[i][j] = way[i-1][j];

                }

                 if((j-1) >= 0 && obstacleGrid[i][j-1] == 0)

                {

                    way[i][j] += way[i][j-1];

                }

            }

        return way[m-1][n-1];

    }

}
