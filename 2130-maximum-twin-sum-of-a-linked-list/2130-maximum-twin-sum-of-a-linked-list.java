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
    public int pairSum(ListNode head) {
        ListNode mid = getMid(head);
        
        ListNode prev = null, curr = head, CN =curr.next;
        
        while(curr!=mid){
            curr.next = prev;
            prev = curr;
            curr = CN;
            CN = curr.next;
        }
        curr = prev;
        int maxSum = 0;
        while(curr!=null){
            int sum = curr.val + mid.val;
            maxSum = Math.max(maxSum,sum);
            curr = curr.next;
            mid = mid.next;
        }
        
        return maxSum;
        
    }
    
    private ListNode getMid(ListNode head){
        ListNode slow =head, fast=head;
        
        while(fast!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}