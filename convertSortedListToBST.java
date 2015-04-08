//bottom-up,time O(n),space O(logn)
/**

 * Definition for singly-linked list.

 * public class ListNode {

 *     int val;

 *     ListNode next;

 *     ListNode(int x) { val = x; next = null; }

 * }

 */

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

    private ListNode cur = null;

    public TreeNode sortedListToBST(ListNode head) {

        cur = head;

        int len = 0;

        ListNode p = head;

        while(p != null)

        {

            len++;

            p = p.next;

        }

        return find(1,len);

    }

    public TreeNode find(int low, int high)

    {

        if(low > high)

            return null;

        int mid = (low+high)/2;

        TreeNode lc = find(low,mid-1);

        TreeNode root = new TreeNode(cur.val);

        root.left = lc;

        cur = cur.next;

        root.right = find(mid+1,high);

        return root;

    }

}
