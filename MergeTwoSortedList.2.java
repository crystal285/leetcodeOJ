//recursion version
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

        if(l1 == null)

            return l2;

        else if(l2 == null)

            return l1;

        else

        {

            if(l1.val <= l2.val)

            {

                ListNode node = mergeTwoLists(l1.next,l2);

                l1.next = node;

                return l1;

            }

            else

            {

                ListNode node = mergeTwoLists(l1,l2.next);

                l2.next = node;

                return l2;

            }

        }

    }

}
