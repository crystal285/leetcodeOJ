//original version.Simple recursion.time cost is a little bit high
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

       root = find(root); 

    }

    TreeNode find(TreeNode node)

    {

        if(node == null)

            return null;

        TreeNode lchild = find(node.left);

        TreeNode rchild = find(node.right);

        if(lchild == null)

            return node;

        if(lchild != null)

        {

            node.right = lchild;

            node.left = null;//pay attention here, otherwise TLE

            if(rchild != null)

            {

            while(lchild.right != null)

                lchild = lchild.right;

            lchild.right = rchild;

            }

        }

       return node;     

    }

}
