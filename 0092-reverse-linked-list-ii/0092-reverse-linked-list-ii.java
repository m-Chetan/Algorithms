/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = head, prev = dummy;
        
        int count = 1;
        
        while(count!=left){
            curr = curr.next;
            prev = prev.next;
            count++;
        }
        ListNode CN = curr.next, leftLL = prev;
        
        while(count!=right){
            curr.next = prev;
            prev = curr;
            curr = CN;
            CN = curr.next;
            count++;
        }
        
        curr.next = prev;
        leftLL.next.next = CN;
        leftLL.next = curr;
        
        return dummy.next;
    }
}