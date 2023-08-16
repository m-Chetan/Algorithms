class Solution {
    public String removeStars(String s) {
        //without stack Two pointer
        StringBuilder sb = new StringBuilder("");
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '*'){
                sb.deleteCharAt(sb.length()-1);
            }
            else sb.append(ch);
        }
        
        return sb.toString();
        
        
//         Stack<Character> stk = new Stack<>();
        
//         for(char ch: s.toCharArray()){
//             if(ch == '*'){
//                 stk.pop();
//             }
//             else stk.push(ch);
//         }
        
//         String res = "";
        
//         while(stk.size()>0){
//             res = stk.pop() + res;
//         }
        
//         return res;
    }
}