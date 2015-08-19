/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
 // directly make use of the ‘next link’ generated already
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null || root.left == null)
           return;
          root.left.next = root.right;
        if(root.next != null)
        {
            root.right.next = root.next.left;
        }
        else
        {
            root.right.next = null;
        }
        connect(root.left);
        connect(root.right);
}
}