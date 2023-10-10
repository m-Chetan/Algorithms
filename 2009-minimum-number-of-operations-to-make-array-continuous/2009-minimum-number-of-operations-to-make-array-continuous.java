class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        
        int res=0;
        
        int start=0;
        int count = 1;
        for(int end=0;end<n;end++){
            while(nums[end] >= nums[start]+n){
                start++;
                if(start>0 && nums[start]!=nums[start-1]) count--;
            }
            if(end>0 && nums[end]!=nums[end-1]) count++;
            
            res = Math.max(res,count);
        }
      
        res = Math.max(res,count);
            
        return n-res;
    }
}