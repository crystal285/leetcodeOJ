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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);

        ListNode cur = dummy;

        if(l1 == null)

            return l2;

        else if(l2 == null)

            return l1;

        else

        {

            while(l1 != null && l2 != null)

            {

                if(l1.val <= l2.val)

                {

                    cur.next = l1;

                    l1 = l1.next;

                }

                else

                {

                    cur.next = l2;

                    l2 = l2.next;

                }

                cur = cur.next;

            }

            if(l1 == null)

                cur.next = l2;

            else

                cur.next = l1;

        }

        return dummy.next;

    }

}
