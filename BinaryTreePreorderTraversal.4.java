//morris traversal.Time O(n),space O(1)
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

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<Integer>();

        while(root != null)

        {

            if(root.left == null)

            {

                 list.add(root.val);

                root = root.right;

            }

            else

            {

                TreeNode cur = root.left;

                while(cur.right != null && cur.right != root)

                    cur = cur.right;

                if(cur.right == null)

                {

                    cur.right = root;

                    list.add(root.val);

                    root = root.left;

                }

                else

                {

                    cur.right = null;

                    root = root.right;

                }

            }

        }

        return list;

    }

}
