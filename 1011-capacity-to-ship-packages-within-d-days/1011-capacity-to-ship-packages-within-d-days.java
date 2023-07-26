class Solution {
    public boolean isPossible(int[] nums, int days, int weight){
        int count = 1;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            
            if(sum + nums[i] <= weight){
                sum += nums[i];
            }
            else{
                count++;
                sum = nums[i]; 
                if(count > days) return false;
            }
        }
        
        return true;
        
    }
    public int shipWithinDays(int[] nums, int days) {
        int low = 0;
        int high = 0;
        
        for(int i=0;i<nums.length;i++){
            low = Math.max(low,nums[i]);
            high += nums[i];
        }

        while(low <= high){
            int mid = (low + high)/2;
            if(isPossible(nums,days,mid)){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        
        return low;
    
    }
}