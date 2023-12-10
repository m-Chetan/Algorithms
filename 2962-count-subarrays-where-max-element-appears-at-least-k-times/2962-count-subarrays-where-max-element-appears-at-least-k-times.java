class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        for(int e: nums) max = Math.max(e,max);
        
        long lessThanK = 0;
        
        int maxCount=0;
        int start=0;
        for(int end=0;end<n;end++){
            if(nums[end]==max) maxCount++;
            
            while(maxCount>=k){
                if(nums[start]==max) maxCount--;
                start++;
            }
            
            lessThanK += end-start+1;
        }
        
        long greaterThan = (long)n * (long)(n+1)/2;
        
        return greaterThan - lessThanK;
    }
}