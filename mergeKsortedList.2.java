//mergesort nonrecursion verison. time O(nklogk) space O(1)
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

    public ListNode mergeKLists(List<ListNode> lists) {

        if(lists == null || lists.size() == 0)

            return null;

        int end = lists.size()-1;

        while(end > 0)

        {

            int start = 0;

            while(start < end)

            {

                lists.set(start, merge(lists.get(start), lists.get(end)));

                start++;

                end--;

            }

        }

        return lists.get(0);

    }

   

    public ListNode merge(ListNode l1, ListNode l2)

    {

        ListNode dummy = new ListNode(0);

        ListNode cur = dummy;

        while(l1 != null && l2 != null)

        {

            if(l1.val <= l2.val)

            {

                cur.next = l1;

                l1 = l1.next;

                cur = cur.next;

            }

            else

            {

                cur.next = l2;

                l2 = l2.next;

                cur = cur.next;

            }

        }

            if(l1 == null)

                cur.next = l2;

            else if(l2 == null)

                cur.next = l1;

        return dummy.next;

    }

}
