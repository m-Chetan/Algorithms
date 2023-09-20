class Solution {
    //Instead of taking elements from right and left find the longest subarray in middle whose sum = totalsum - x
    
    public int minOperations(int[] nums, int x) {
        int n=nums.length;
        int sum = 0;
        for(int num:nums) sum+= num;
        
        sum -= x;
        int res = Integer.MAX_VALUE;
        
        int start=0, currSum=0;
        for(int end=0;end<n;end++){
            currSum += nums[end];
            
            while(start<=end && currSum>sum){
                currSum -= nums[start];
                start++;
            }
            
            if(currSum==sum){
                res = Math.min(res,n-(end-start+1));
            }
            
        }
        
        return res==Integer.MAX_VALUE ? -1 : res;
        
    }
}