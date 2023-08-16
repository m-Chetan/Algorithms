class Solution {
    public String removeStars(String s) {
        Stack<Character> stk = new Stack<>();
        
        for(char ch: s.toCharArray()){
            if(ch == '*'){
                stk.pop();
            }
            else stk.push(ch);
        }
        
        String res = "";
        
        while(stk.size()>0){
            res = stk.pop() + res;
        }
        
        return res;
    }
}