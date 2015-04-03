//dummy node
/**

 * Definition for singly-linked list.

 * public class ListNode {

 *     int val;

 *     ListNode next;

 *     ListNode(int x) {

 *         val = x;

 *         next = null;

 *     }

 * }

 */

public class Solution {

    public ListNode swapPairs(ListNode head) {

        if(head == null)

            return null;

        ListNode dummy = new ListNode(0);

        ListNode cur = dummy;

        ListNode n = head;

        while(n != null)

        {

            if(n.next == null)

                cur.next = n;

            else

            {

                ListNode temp = n.next;

                n.next = n.next.next;

                temp.next = n;

                cur.next = temp;

                cur = n;

            }

            n = n.next;

        }

        return dummy.next;

    }

}
