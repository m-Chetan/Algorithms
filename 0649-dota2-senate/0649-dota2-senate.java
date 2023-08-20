class Solution {
    public String predictPartyVictory(String senate){
        int n = senate.length();
        Deque<Integer> rad = new ArrayDeque<>();
        Deque<Integer> dir = new ArrayDeque<>();
        
        for(int i=0;i<n;i++){
            if(senate.charAt(i)=='R') rad.add(i);
            else dir.add(i);
        }
      
        while(rad.size()>0 && dir.size()>0){
            if(rad.peek() < dir.peek()){
                rad.add(n++);
                rad.remove();
                dir.remove();
            }
            else{
                dir.add(n++);
                dir.remove();
                rad.remove();
            }
        }
        
        return rad.size()==0 ? "Dire" : "Radiant";
    }
    
    
//     public String predictPartyVictory(String senate) {
//         Deque<Character> q = new ArrayDeque<>();
//         for(char ch: senate.toCharArray()) q.add(ch);
        
//         while(q.size()>1){
//             char ch = q.remove();
//             if(ch=='R'){
//                 int count = 0;
//                 while(q.size()>0 && q.peek()!='D'){
//                     q.remove();
//                     count++;
//                 }
//                 if(q.size()==0) return "Radiant";
//                 q.remove();
//                 while(count-->0) q.addFirst('R');
//                 q.addLast(ch);
//             }
//             else{
//                 int count = 0;
//                 while(q.size()>0 && q.peek()!='R'){
//                     q.remove();
//                     count++;
//                 }
//                 if(q.size()==0) return "Dire";
//                 q.remove();
//                 while(count-->0) q.addFirst('D');
//                 q.addLast(ch);
//             }
//         }
        
//         return q.peek() == 'R' ? "Radiant" : "Dire";
//     }
}