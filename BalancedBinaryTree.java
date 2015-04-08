//time O(n),space O(n)
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

    public boolean isBalanced(TreeNode root) {

        return find(root) != -1; 

    }

    public int find(TreeNode root)

    {

        if(root == null)

            return 0;

        int hleft = find(root.left);

        if(hleft == -1)

            return -1;

        int hright = find(root.right);

        if(hright == -1)

            return -1;

        if(Math.abs(hleft-hright) > 1)

            return -1;

        return Math.max(hleft,hright)+1;

    }

}
