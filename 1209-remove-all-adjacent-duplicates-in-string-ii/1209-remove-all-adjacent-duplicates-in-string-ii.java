class Solution {
    class Node{
        Character ch;
        int count;
        public Node(Character ch, int count){
            this.ch = ch;
            this.count = count;
        }
    }
    
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        
        Stack<Node> stk = new Stack<>();
        stk.add(new Node(s.charAt(0), 1));
        
        int i =1;
        
        while(i<n){
            char ch = s.charAt(i);
            if(stk.size()==0){
                stk.push(new Node(ch,1));
                i++;
                continue;
            }
            
            Node top = stk.peek();
            
            if(top.ch == ch){
                top.count++;
            }
            else stk.push(new Node(ch,1));
            
            if(top.count == k) stk.pop();
            
            i++;
        }
        
        String res = "";
        
        while(stk.size()>0) {
            
            for(i=0;i<stk.peek().count;i++)
                res = stk.peek().ch + res;
            
            stk.pop();
        }
        
        return res;
        
    }
}