class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        boolean increasing = true;
        if(nums[n-1]<nums[0]) increasing = false;
        
        for(int i=1;i<n;i++){
            if(increasing){
                if(nums[i]<nums[i-1]) return false;
            }
            else{
                if(nums[i]>nums[i-1]) return false;
            }
        }
        
        return true;
    }
}