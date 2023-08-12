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
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode();
        ListNode right = new ListNode();
        
        ListNode leftTail = left, rightTail = right, curr = head;
        
        while(curr != null){
            if(curr.val<x){
                leftTail.next = curr;
                leftTail = leftTail.next;
            }    
            else{
                rightTail.next = curr;
                rightTail = rightTail.next; 
            }
            curr = curr.next;    
        }
        
        leftTail.next = right.next;
        rightTail.next = null;
        return left.next;
    }
}