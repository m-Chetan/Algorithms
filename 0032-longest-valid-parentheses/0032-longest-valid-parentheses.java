class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        
        int res = 0;
        
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            
            if(ch == '(') stk.push(i);
            else{
                stk.pop();
                if(stk.size() == 0) stk.push(i);
                
                res = Math.max(res,i-stk.peek());
            }
        }
        
        return res;
    }
}