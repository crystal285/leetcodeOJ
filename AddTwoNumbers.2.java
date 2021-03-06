//more concise version
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);

        ListNode cur = dummy;

        int carry = 0;

        while(l1 != null || l2 != null)

        {

            if(l1 != null)

            {

                carry += l1.val;

                l1 = l1.next;

            }

            if(l2 != null)

            {

                carry += l2.val;

                l2 = l2.next;

            }

            ListNode node = new ListNode(carry % 10);

            carry = carry / 10;

            cur.next = node;

            cur = cur.next;

        }

        if(carry == 1)

            cur.next = new ListNode(1);

        return dummy.next;

    }

}
