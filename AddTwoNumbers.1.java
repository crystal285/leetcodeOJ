//original version
/**

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

       int carry = 0;

       ListNode dummy = new ListNode(0);

       ListNode cur = dummy;

       while(l1 != null && l2 != null)

       {

           int v = l1.val + l2.val + carry;

           cur.next = new ListNode(v % 10);

           cur = cur.next;

           l1 = l1.next;

           l2 = l2.next;

           carry = v / 10;

       }

           while(l2 != null)

           {

               int v = l2.val + carry;

               cur.next = new ListNode(v % 10);

               cur = cur.next;

               l2 = l2.next;

               carry = v / 10;

           }

           while(l1 != null)

           {

               int v = l1.val + carry;

               cur.next = new ListNode(v % 10);

               cur = cur.next;

               l1 = l1.next;

               carry = v / 10;

           }

           if(carry == 1)

            cur.next = new ListNode(1);

       return dummy.next;

}

}
