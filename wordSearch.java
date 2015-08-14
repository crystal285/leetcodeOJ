public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0)
            return false;
        if(word.length() == 0)
            return true;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visit = new boolean[m][n];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(find(board,word,0,i,j,visit))
                    return true;
            }
    }
    return false;
    }
    public boolean find(char[][] board, String word, int index, int x, int y, boolean[][] visit)
    {
        if(index == word.length())
            return true;
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length || word.charAt(index) != board[x][y] || visit[x][y] == true)
            return false;
        visit[x][y] = true;
        boolean check = find(board,word,index+1,x,y+1,visit) || find(board,word,index+1,x+1,y,visit) || find(board,word,index+1,x,y-1,visit) || find(board,word,index+1,x-1,y,visit);
        visit[x][y] = false;
        return check;
    }
}