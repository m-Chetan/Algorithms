class Solution {
    public int maxProduct(int[] nums) {
        int minNum = nums[0];
        int maxNum = nums[0];
        int res = nums[0];
        for(int i=1;i<nums.length;i++){
            int temp= Math.max(nums[i],Math.max(nums[i]*maxNum,nums[i]*minNum));
            minNum = Math.min(nums[i],Math.min(nums[i]*maxNum,nums[i]*minNum));
            maxNum = temp;
            res = Math.max(res,maxNum);
        }
        
        return res;
    }
}