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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(root == null)
            return lists;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        boolean flag = true;
        while(!stack.isEmpty())
        {
            Stack<TreeNode> next = new Stack<TreeNode>();
            List<Integer> list = new ArrayList<Integer>();
            while(!stack.isEmpty())
            {
                TreeNode node = stack.pop();
                list.add(node.val);
                if(flag)
                {
                    if(node.left != null)
                        next.push(node.left);
                    if(node.right != null)
                        next.push(node.right);
                }
                else
                {
                    if(node.right != null)
                        next.push(node.right);
                    if(node.left != null)
                        next.push(node.left);
                }
            }
            lists.add(list);
            flag = !flag;
            stack = next;
        }
        return lists;
    }
}