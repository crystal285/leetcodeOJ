//in-order traversal, time O(n), space O(n)
/**

 * Definition for binary tree

 * public class TreeNode {

 *     int val;

 *     TreeNode left;

 *     TreeNode right;

 *     TreeNode(int x) { val = x; }

 * }

 */

public class Solution {

    public TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {

        return isValid(root);

    }

    public boolean isValid(TreeNode node)

    {

        if(node == null)

            return true;

        if(isValid(node.left))

        {

            if(pre != null && pre.val >= node.val)

            {

                return false;

            }

        pre = node;

        return isValid(node.right);

        }

        else

            return false;

    }

}
