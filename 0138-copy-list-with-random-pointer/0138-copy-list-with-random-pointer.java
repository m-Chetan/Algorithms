/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;
        Node dummy = new Node(-1);
        Node dn = dummy;    //dummy next
        
        HashMap<Node,Node> hm = new HashMap<>();    //oldNode --> newNode
        
        while(curr != null){
            Node newNode = new Node(curr.val);
            hm.put(curr,newNode);
            dn.next = newNode;
            dn = dn.next;
            curr = curr.next;
        }
    
        curr = head;
        Node temp = dummy.next;
        
        while(curr!=null){
            if(curr.random == null) temp.random = null;
            else{
                Node node = curr.random;
                temp.random = hm.get(node);
            }
            curr = curr.next;
            temp = temp.next;
        }
        
        return dummy.next;
    }
}