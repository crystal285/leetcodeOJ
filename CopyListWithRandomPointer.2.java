//time O(n),space O(1).
/**

 * Definition for singly-linked list with a random pointer.

 * class RandomListNode {

 *     int label;

 *     RandomListNode next, random;

 *     RandomListNode(int x) { this.label = x; }

 * };

 */

public class Solution {

    public RandomListNode copyRandomList(RandomListNode head) {

        if(head == null)

            return null;

        RandomListNode old = head;

        while(old != null)

        {

            RandomListNode n = new RandomListNode(old.label);

            n.next = old.next;

            old.next = n;

            old = n.next;

        }

        old = head;

        while(old != null)

        {

            if(old.random != null)

                old.next.random = old.random.next;

            old = old.next.next;

        }

        old = head;

        RandomListNode dummy = new RandomListNode(0);

        RandomListNode cp = dummy;

        while(old != null)

        {

            cp.next = old.next;

            old.next = old.next.next;

            old = old.next;

            cp = cp.next;

        }

        return dummy.next;

    }

}
