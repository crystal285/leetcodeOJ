//interative with a stack
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

    public void flatten(TreeNode root) {

        if (root == null)

            return;

        Stack<TreeNode> stack = new Stack<TreeNode>();

       TreeNode cur = root;

       while(cur != null)

       {

           while(cur.left != null)

           {

               if(cur.right != null)

               {

                   TreeNode r = cur.right;

                   stack.push(r);

               }

                   cur.right = cur.left;

                   cur.left = null;

                   cur = cur.right;

           }

           if(cur.right == null && !stack.isEmpty())

           {

               cur.right = stack.pop();

           }

           cur = cur.right;

       }

    }

}
