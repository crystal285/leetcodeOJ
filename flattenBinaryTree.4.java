//iterative without stack. Each node can be visited at most twice. Space O(1)
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

        TreeNode cur = root;

        while(cur != null)

        {

            if(cur.left != null)

            {

                

              if(cur.right != null)

              {

                TreeNode temp = cur.left;

                while(temp.right != null)

                {

                    temp = temp.right;

                }

                temp.right = cur.right;

              }

              cur.right = cur.left;

              cur.left = null;

            }

            cur = cur.right;

        }

    }

}
