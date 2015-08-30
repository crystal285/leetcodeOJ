/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//version2:Morris Traversal, space O(1)
public class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        TreeNode pre = null;
        TreeNode current = root;
        while(current != null)
        {
            if(pre != null && pre.val > current.val)
            {
                if(first == null)
                {
                    first = pre;
                    second = current;
                }
                else
                    second = current;
            }
            if(current.left == null)
            {
                pre = current;
                current = current.right;
            }
            else
            {
                TreeNode node = current.left;
                while(node.right != null && node.right != current)
                    node = node.right;
                if(node.right == null)
                {
                    node.right = current;
                    current = current.left;
                }
                else
                {
                    node.right = null;
                    pre = current;
                    current = current.right;
                }
            }
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}