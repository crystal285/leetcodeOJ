//traverse only one time as a preorder traversal. Use a global variable to store the previous node
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

    private TreeNode last = null;

    public void flatten(TreeNode root) {

      if(root == null)

        return;

        if(last != null)

        {

            last.right = root;

            last.left = null;

        }

      last = root;

      TreeNode oldright = root.right;

      flatten(root.left);

      flatten(oldright);

    }

}
