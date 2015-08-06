//DFS
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) return ans;
        traverse(ans, root, 0);
        return ans;
    }
    public void traverse(List<List<Integer>> ans, TreeNode root, int level)
    {
        if(root == null)
            return;
        if(ans.size() < level + 1)
        {
            List<Integer> list = new ArrayList<Integer>();
            ans.add(list);
        }
            ans.get(level).add(root.val);
        traverse(ans,root.left,level+1);
        traverse(ans,root.right,level+1);
    }
}