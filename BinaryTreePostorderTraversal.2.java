//iteration version
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

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();

        if(root == null)

            return list;

        stack.push(root);

        TreeNode pre = null;

        TreeNode cur = root;

        while(!stack.isEmpty())

        {

            cur = stack.peek();

            if(pre == null || pre.left == cur || pre.right == cur)//traverse down the tree

            {

                if(cur.left != null)

                {

                    stack.push(cur.left);

                   

                    

                }

                else if(cur.right != null)

                {

                    stack.push(cur.right);

                    

                }

               

            }

            else if(cur == pre)//leaf node

            {

                list.add(cur.val);

                stack.pop();

            }

            else if(cur.left == pre)//traverse up from left child

            {

                if(cur.right != null)

                    stack.push(cur.right);

            }

            else if(cur.right == pre)//traverse up from right child

            {

                list.add(cur.val);

                stack.pop();

            }

            pre = cur;

        }

        return list;

    }

}
