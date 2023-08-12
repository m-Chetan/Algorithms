class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] res = new int[n];
        
        Stack<Integer> stk = new Stack<>();
        
        for(int i=n-1;i>=0;i--){
            
            while(stk.size()>0 && temp[stk.peek()] <= temp[i]){
                stk.pop();
            }
            if(stk.size()>0) res[i] = stk.peek()-i;
            stk.push(i);
        }
        
        return res;
    }
}