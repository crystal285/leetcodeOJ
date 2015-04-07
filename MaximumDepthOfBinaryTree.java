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

    private int max=0;

    public int maxDepth(TreeNode root) {

        int count = 0;

        find(root,count);

        return max;

    }

    public void find(TreeNode root, int count)

    {

        if(root == null)

            return;

        count++;

        if(max < count)

            max = count;

        find(root.left,count);

        find(root.right,count);

    }

}
