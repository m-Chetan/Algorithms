class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        
        Deque<int[]> dq = new ArrayDeque<>();
        dq.addFirst(new int[]{0,nums[0]});
        
        int res = Integer.MIN_VALUE;
        
        for(int i=1; i<n; i++){
            if(i-dq.peekFirst()[0] > k){
                res = Math.max(res,dq.removeFirst()[1]);
            }
            int currSum = nums[i]+dq.getFirst()[1];
            
            while(dq.size()>0 && nums[i]+dq.getFirst()[1] > dq.getLast()[1]){
                dq.removeLast();                
            }
            int max = Math.max(currSum,nums[i]);
            dq.addLast(new int[]{i,max});
        }
        
        res = Math.max(res,dq.getFirst()[1]);
        
        return res;
        
    }
}