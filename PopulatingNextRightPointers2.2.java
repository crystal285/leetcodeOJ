/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
//non-recursion
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode head = null;
        TreeLinkNode tail = null;
        TreeLinkNode cur = root;
        while(cur != null)
        {
            if(cur.left != null)
            {
                if(head == null)
                {
                    head = cur.left;
                    tail = cur.left;
                }
                else
                {
                    tail.next = cur.left;
                    tail = tail.next;
                }
            }
            if(cur.right != null)
            {
                if(head == null)
                {
                    head = cur.right;
                    tail = cur.right;
                }
                else
                {
                    tail.next = cur.right;
                    tail = tail.next;
                }
            }
            cur = cur.next;
            if(cur == null)
            {
                cur = head;
                head = null;
                tail = null;
            }
        }
    }
}