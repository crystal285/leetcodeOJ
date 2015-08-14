public class Solution {
    class TrieNode
    {
        boolean isLeaf;
        HashMap<Character,TrieNode> children;
        String s;
        public TrieNode()
        {
            children = new HashMap<Character,TrieNode>();
            isLeaf = false;
            s = "";
        }
    }
    
    class TrieTree
    {
        TrieNode root;
        public TrieTree()
        {
            root = new TrieNode();
        }
        
        public void insert(String s)
        {
            TrieNode node = root;
            for(int i = 0; i < s.length(); i++)
            {
                char c = s.charAt(i);
                if(!node.children.containsKey(c))
                    node.children.put(c,new TrieNode());
                node = node.children.get(c);
            }
            node.isLeaf = true;
            node.s = s;
        }
        
        public boolean find(String s)
        {
            TrieNode node = root;
            for(int i = 0; i < s.length(); i++)
            {
                char c = s.charAt(i);
                if(!node.children.containsKey(c))
                    return false;
                node = node.children.get(c);
            }
            return node.isLeaf;
        }
    }
    
    public int[] dx = {1,0,-1,0};
    public int[] dy = {0,1,0,-1};
    public List<String> findWords(char[][] board, String[] words) {
        List<String> rs = new ArrayList<String>();
        TrieTree tree = new TrieTree();
        for(String s : words)
            tree.insert(s);
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                find(board,tree.root,i,j,rs);
            }
        }
        return rs;
    }
    
    public void find(char[][] board, TrieNode root,int x, int y, List<String> rs)
    {
        if(root.isLeaf)
        {
            if(!rs.contains(root.s))// pay attention here, no return statement, must check the duplicate
            rs.add(root.s);
        }
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length || !root.children.containsKey(board[x][y]))
            return;
        char ch = board[x][y];
       board[x][y] = '#';
        for(int i = 0; i < 4; i++)
        {
            find(board,root.children.get(ch),x+dx[i],y+dy[i],rs);
        }
       board[x][y] = ch;
    }
}