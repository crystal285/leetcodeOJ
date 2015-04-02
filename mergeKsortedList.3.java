//heapsort version.time O(nklogk) space O(k)
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

        ListNode dummy = new ListNode(0);

        ListNode cur = dummy;

        int k = lists.size();

        Queue<ListNode> minheap = new PriorityQueue<ListNode>(k,new myComparator());

        for(ListNode node : lists)

        {

            if(node != null)

                minheap.add(node);

        }

        while(!minheap.isEmpty())

        {

            cur.next = minheap.poll();

            cur = cur.next;

            if(cur.next != null)

                minheap.add(cur.next);

        }

        return dummy.next;

    }

   class myComparator implements Comparator<ListNode>

   {

       public int compare(ListNode l1, ListNode l2)

       {

           return l1.val - l2.val;

       }

   }

}
