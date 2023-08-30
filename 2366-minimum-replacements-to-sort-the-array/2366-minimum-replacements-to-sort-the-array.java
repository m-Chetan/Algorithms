class Solution {
    public long minimumReplacement(int[] nums) {
        int n = nums.length;
        
        int i=n-2;
        int smallest = nums[n-1];
        long res = 0;
        while(i>=0){
            if(nums[i] <= smallest){
                smallest = nums[i];
                i--;
                continue;
            }
            int splits = (nums[i]/smallest);
            if(nums[i]%smallest != 0) splits++;
            res += splits-1;
            smallest = nums[i]/splits;
            i--;
        }
        
        return res;
        
    }
}