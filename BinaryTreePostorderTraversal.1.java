//recursion version
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

        find(root,list);

        return list;

    }

    public void find(TreeNode root, List<Integer> list)

    {

        if(root == null)

            return;

        find(root.left,list);

        find(root.right,list);

        list.add(root.val);

    }

}
