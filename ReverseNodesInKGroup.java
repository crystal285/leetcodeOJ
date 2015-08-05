/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1 || head == null)
            return head;
        ListNode nextGroup = head; 
        for(int i = 0; i < k; i++)
        {
            if(nextGroup == null)
                return head;
            nextGroup = nextGroup.next;
        }
        ListNode cur = head;
        ListNode next = cur.next;
        while(next != nextGroup)
        {
            ListNode temp = next.next;
            next.next = cur;
            cur = next;
            next = temp;
        }
        head.next = reverseKGroup(nextGroup,k);
        return cur;
        
    }
}