class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        
        for(int i=0;i<=heights.length;i++){
            int currVal = (i<heights.length) ? heights[i] : Integer.MIN_VALUE;
            while(stk.peek() != -1 && currVal < heights[stk.peek()]){
                int idx = stk.pop();
                ans = Math.max(ans,heights[idx]*(i-stk.peek()-1));
            } 
            stk.push(i);
        }
        
        return ans; 
    }
}