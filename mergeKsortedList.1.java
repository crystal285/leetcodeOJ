//mergesort version. time O(nklogk)
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

        return mergeSort(lists,0,lists.size()-1);

    }

    public ListNode mergeSort(List<ListNode> lists, int low, int high)

    {

        if(low == high)

            return lists.get(low);

        int mid = (low + high) / 2;

        return merge(mergeSort(lists,low,mid),mergeSort(lists,mid+1,high));

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
