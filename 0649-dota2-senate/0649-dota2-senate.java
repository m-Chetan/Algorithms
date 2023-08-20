class Solution {
    public String predictPartyVictory(String senate) {
        Deque<Character> q = new ArrayDeque<>();
        for(char ch: senate.toCharArray()) q.add(ch);
        
        while(q.size()>1){
            char ch = q.remove();
            if(ch=='R'){
                int count = 0;
                while(q.size()>0 && q.peek()!='D'){
                    q.remove();
                    count++;
                }
                if(q.size()==0) return "Radiant";
                q.remove();
                while(count-->0) q.addFirst('R');
                q.addLast(ch);
            }
            else{
                int count = 0;
                while(q.size()>0 && q.peek()!='R'){
                    q.remove();
                    count++;
                }
                if(q.size()==0) return "Dire";
                q.remove();
                while(count-->0) q.addFirst('D');
                q.addLast(ch);
            }
        }
        
        return q.peek() == 'R' ? "Radiant" : "Dire";
    }
}