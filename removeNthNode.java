//pay attention to the case when we need to remove the head
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

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode first = head;

        ListNode second = head;

        while(n > 0)

        {

            if(second.next == null)

                break;

            second = second.next;

            n--;

        }

        if(n == 1)

            head = head.next;

        else

        {

        while(second.next != null)

        {

            second = second.next;

            first = first.next;

        }

        first.next = first.next.next;

        }

        return head;

    }

}
