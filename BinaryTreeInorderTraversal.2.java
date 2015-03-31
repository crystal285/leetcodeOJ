//iteration version
/**

 * public class TreeNode {

 *     int val;

 *     TreeNode left;

 *     TreeNode right;

 *     TreeNode(int x) { val = x; }

 * }

 */

public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {

      List<Integer> list = new ArrayList<Integer>();

      Stack<TreeNode> stack = new Stack<TreeNode>();

      if(root == null)

        return list;

      stack.push(root);

      while(!stack.isEmpty())

      {

          while(root.left != null)

          {

              stack.push(root.left);

              root = root.left;

          }

          list.add(root.val);

          stack.pop();

          

          if(root.right == null)

          {

              while(!stack.isEmpty() && root.right == null)

              {

                  root = stack.pop();

                  list.add(root.val);

              }

          }

          if(root.right != null)

          {

              stack.push(root.right);

              root = root.right;

          }

      }

      return list;

    }

}
