//space O(n), time O(n)
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

        RandomListNode chead = new RandomListNode(head.label);

        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();

        map.put(head,chead);

        RandomListNode cur = chead;

        while(head != null)

        {

            if(head.random != null)

            {

                if(!map.containsKey(head.random))

                {

                    RandomListNode node = new RandomListNode(head.random.label);

                    map.put(head.random,node);

                }

                cur.random = map.get(head.random);

            }

            if(head.next != null)

            {

            if(!map.containsKey(head.next))

            {

                RandomListNode clone = new RandomListNode(head.next.label);

                map.put(head.next,clone);

            }

            cur.next = map.get(head.next);

            }

            cur = cur.next;

            head = head.next;

        }

        return chead;

    }

}
