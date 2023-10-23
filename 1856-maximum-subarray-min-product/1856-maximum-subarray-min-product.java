class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        int MOD = 1000000007;
        
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];
        
        for(int i=1;i<n;i++) prefixSum[i] = prefixSum[i-1] + nums[i];
        
        Stack<Integer> stk = new Stack<>();
        long max = 0;
        stk.push(-1);
            
        for(int i=0;i<=n;i++){
            int val = i<n ? nums[i] : Integer.MIN_VALUE;
            
            while(stk.peek()!=-1 && val<nums[stk.peek()]){
                long right = prefixSum[i-1];
                long ele = nums[stk.pop()];
                long left = stk.peek()==-1 ? 0 : prefixSum[stk.peek()];
                
                max = Math.max(max, ele*(right-left));
            }
            
            stk.push(i);
        }
        
        return (int)(max%MOD);
    }
}