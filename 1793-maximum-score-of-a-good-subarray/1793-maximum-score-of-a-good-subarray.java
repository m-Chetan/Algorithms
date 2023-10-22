class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        
        int max = 0;
        Stack<Integer> stk = new Stack<>();
    
        for(int i=0;i<=n;i++){
            int currVal = (i<n) ? nums[i] : Integer.MIN_VALUE;
            while(stk.size()>0 && currVal<nums[stk.peek()]){
                int right = i;
                int ele = nums[stk.pop()];
                int left = stk.size()>0 ? stk.peek() : -1;
                
                if(k>left && k<right){
                    max = Math.max(max,(right-left-1)*ele);
                }
                
            }
            
            stk.push(i);
        }
        
        
        return max;
    }
}