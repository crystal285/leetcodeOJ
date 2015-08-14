class TrieNode {
    // Initialize your data structure here.
    HashMap<Character,TrieNode> children;
    boolean isLeaf;
    String s;
    public TrieNode() {
        children = new HashMap<Character,TrieNode>();
        isLeaf = false;
        s = "";
    }
}

public class Trie {
    private TrieNode root;//root has no value

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if(!node.children.containsKey(c))
            {
                node.children.put(c,new TrieNode());
            }
            node = node.children.get(c);
        }
        node.s = word;
        node.isLeaf = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode t = searchNode(word);
        if(t != null && t.isLeaf)
            return true;
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(searchNode(prefix) != null)
            return true;
        else
            return false;
    }
   //returns the leaf node if s is in the tree 
    public TrieNode searchNode(String s)
    {
        TrieNode node = root;
         for(int i = 0; i < s.length(); i++)
         {
             char c = s.charAt(i);
             if(!node.children.containsKey(c))
                return null;
            node = node.children.get(c);
         }
         return node;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");