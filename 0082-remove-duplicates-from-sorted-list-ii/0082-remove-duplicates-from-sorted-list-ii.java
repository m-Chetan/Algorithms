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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy, curr = head, CN = curr.next;
        
        while(CN != null){
            if(curr.val == CN.val){
                while(CN!=null && curr.val==CN.val){
                    curr = CN;
                    CN = curr.next;
                }
                prev.next = CN;
                if(CN==null) break;
            }
            else{
                prev = curr;
               
            }
            curr = CN;
            CN = curr.next;
        }
        
        return dummy.next;
    }
}