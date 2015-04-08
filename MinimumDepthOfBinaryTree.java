//time O(n),space O(logn)
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

    public int minDepth(TreeNode root) {

        if(root == null)

            return 0;

        int l = minDepth(root.left)+1;

        int r = minDepth(root.right)+1;

        if(root.left != null && root.right != null)

            return Math.min(l,r);

        if(root.left == null && root.right != null)

            return r;

        if(root.left != null && root.right == null)

            return l;

        else return 1; 

    }

}
