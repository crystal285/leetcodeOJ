//time O(n),space O(logn),divide and conquer

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

    public TreeNode sortedArrayToBST(int[] num) {

        if(num.length == 0)

            return null;

        return find(num,0,num.length-1);

    }

    public TreeNode find(int[] num, int low, int high)

    {

        if(low > high)

            return null;

        int mid = (low+high)/2;

        TreeNode root = new TreeNode(num[mid]);

        root.left = find(num, low, mid-1);

        root.right = find(num, mid+1, high);

        return root;

    }

}
