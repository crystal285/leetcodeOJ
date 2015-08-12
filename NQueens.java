public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> lists = new ArrayList<List<String>>();
        if(n <= 0)
            return lists;
        find(lists,new ArrayList<Integer>(),0,n);
        return lists;
    }
    public void find(List<List<String>> lists,ArrayList<Integer> rs, int row, int n)
    {
        if(row == n)
        {
            List<String> list = new ArrayList<String>(); 
            for(int i = 0; i < n; i++)
            {
                StringBuilder sb = new StringBuilder();
                int col = rs.get(i);
                int j = 0;
                while(j < col)
                {
                    sb.append(".");
                    j++;
                }
                sb.append("Q");
                j++;
                while(j < n)
                {
                    sb.append(".");
                    j++;
                }
                list.add(sb.toString());
            }
            lists.add(list);
            return;
        }
        for(int i = 0; i < n; i++)
        {
            int k;
            for(k = 0; k < row; k++)
            {
                if(Math.abs(i - rs.get(k)) == row - k || rs.get(k) == i)
                {
                    break;
                }
            }
            if(k == row)
            {
               rs.add(i);
                find(lists,rs,row+1,n);
                rs.remove(rs.size()-1);
            }
        }
    }
}