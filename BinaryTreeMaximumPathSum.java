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

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        find(root);

        return max;

    }

    public int find(TreeNode root)

    {

        if(root == null)

            return 0;

        int leftsum = find(root.left);

        int rightsum = find(root.right);

        if(leftsum < 0)

            leftsum = 0;

        if(rightsum < 0)

            rightsum = 0;

        if(max < (leftsum+rightsum+root.val))

            max = leftsum+rightsum+root.val;

        return Math.max(leftsum,rightsum)+root.val;

    }

}
