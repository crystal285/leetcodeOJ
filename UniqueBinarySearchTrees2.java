/**

 * Definition for binary tree

 * public class TreeNode {

 *     int val;

 *     TreeNode left;

 *     TreeNode right;

 *     TreeNode(int x) { val = x; left = null; right = null; }

 * }

 */

public class Solution {

    public List<TreeNode> generateTrees(int n) {

        return find(1,n);

    }

    public List<TreeNode> find(int start, int end)

    {

        List<TreeNode> lists = new ArrayList<TreeNode>();

        if(start > end)

        {

            lists.add(null);

            return lists;

        }

        for(int i = start; i <= end; i++)

        {

            List<TreeNode> leftlist = find(start,i-1);

            List<TreeNode> rightlist = find(i+1,end);

            for(TreeNode l : leftlist)

            {

                for(TreeNode r : rightlist)

                {

                    TreeNode cur = new TreeNode(i);

                    cur.left = l;

                    cur.right = r;

                    lists.add(cur);

                }

            }

        }

        return lists;

    }

}
