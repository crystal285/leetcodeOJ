public class Solution {
    private int num = 0;
    public int totalNQueens(int n) {
        if(n <= 0)
            return num;
        int[] map = new int[n];
        find(map,0,n);
        return num;
    }
    public void find(int[] map,int row, int n)
    {
        if(row == n)
        {
            num++;
            return;
        }
        for(int i = 0; i < n; i++)
        {
            map[row] = i;
            int k;
            for(k = 0; k < row; k++)
            {
                if(map[row] == map[k] || Math.abs(map[row]-map[k]) == row - k)
                    break;
            }
            if(k == row)
            {
                find(map,row+1,n);
            }
        }
    }
}