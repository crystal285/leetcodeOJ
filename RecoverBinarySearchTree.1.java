/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//version 1: using two pointers, in-order traversal, space O(lgn)
public class Solution {
    private TreeNode pre = null;
    private TreeNode first = null;
    private TreeNode second = null;
    public void recoverTree(TreeNode root) {
        find(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    public void find(TreeNode root)
    {
        if(root == null)
            return;
        find(root.left);
        if(pre != null && pre.val > root.val)
        {
            if(first == null)
            {
                first = pre;
                second = root;
            }
            else
                second = root;//pay attention
        }
         pre = root;
         find(root.right);
    }
}