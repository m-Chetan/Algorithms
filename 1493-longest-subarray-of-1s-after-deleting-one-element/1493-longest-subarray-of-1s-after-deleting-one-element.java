class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 0;
        int countZero = 0;
        int start = 0;
        
        for(int end=0;end<nums.length;end++){
            if(nums[end] == 0) countZero++;
            
            while(countZero==2){
                if(nums[start]==0) countZero--;
                start++;
            }
            
            ans = Math.max(ans,end-start-countZero+1);
        }
        
        if(countZero == 0) return nums.length-1;
        
        return ans;
    }
}