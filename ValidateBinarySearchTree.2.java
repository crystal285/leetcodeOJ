//range narrow version. Time O(n), space O(logN) if the tree is binary
/**
*Definition for binary tree

 * public class TreeNode {

 *     int val;

 *     TreeNode left;

 *     TreeNode right;

 *     TreeNode(int x) { val = x; }

 * }

 */

public class Solution {

    public static boolean isValidBST(TreeNode root) {

    return validate(root, null, null);

}



public static boolean validate(TreeNode root, Integer min, Integer max) {

    if (root == null) return true;

    if (min != null && root.val <= min || max != null && root.val >= max)

        return false;

    return validate(root.left, min, root.val) 

        && validate(root.right, root.val, max);

}

}
