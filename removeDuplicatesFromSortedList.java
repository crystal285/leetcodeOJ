/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
       if(head == null)
        return head;
        ListNode cur = head;
        ListNode pre = head;
        while(cur.next != null)
        {
            cur = cur.next;
            if(cur.val == pre.val)
                pre.next = cur.next;
            else
                pre = pre.next;
        }
        return head;
    }
}