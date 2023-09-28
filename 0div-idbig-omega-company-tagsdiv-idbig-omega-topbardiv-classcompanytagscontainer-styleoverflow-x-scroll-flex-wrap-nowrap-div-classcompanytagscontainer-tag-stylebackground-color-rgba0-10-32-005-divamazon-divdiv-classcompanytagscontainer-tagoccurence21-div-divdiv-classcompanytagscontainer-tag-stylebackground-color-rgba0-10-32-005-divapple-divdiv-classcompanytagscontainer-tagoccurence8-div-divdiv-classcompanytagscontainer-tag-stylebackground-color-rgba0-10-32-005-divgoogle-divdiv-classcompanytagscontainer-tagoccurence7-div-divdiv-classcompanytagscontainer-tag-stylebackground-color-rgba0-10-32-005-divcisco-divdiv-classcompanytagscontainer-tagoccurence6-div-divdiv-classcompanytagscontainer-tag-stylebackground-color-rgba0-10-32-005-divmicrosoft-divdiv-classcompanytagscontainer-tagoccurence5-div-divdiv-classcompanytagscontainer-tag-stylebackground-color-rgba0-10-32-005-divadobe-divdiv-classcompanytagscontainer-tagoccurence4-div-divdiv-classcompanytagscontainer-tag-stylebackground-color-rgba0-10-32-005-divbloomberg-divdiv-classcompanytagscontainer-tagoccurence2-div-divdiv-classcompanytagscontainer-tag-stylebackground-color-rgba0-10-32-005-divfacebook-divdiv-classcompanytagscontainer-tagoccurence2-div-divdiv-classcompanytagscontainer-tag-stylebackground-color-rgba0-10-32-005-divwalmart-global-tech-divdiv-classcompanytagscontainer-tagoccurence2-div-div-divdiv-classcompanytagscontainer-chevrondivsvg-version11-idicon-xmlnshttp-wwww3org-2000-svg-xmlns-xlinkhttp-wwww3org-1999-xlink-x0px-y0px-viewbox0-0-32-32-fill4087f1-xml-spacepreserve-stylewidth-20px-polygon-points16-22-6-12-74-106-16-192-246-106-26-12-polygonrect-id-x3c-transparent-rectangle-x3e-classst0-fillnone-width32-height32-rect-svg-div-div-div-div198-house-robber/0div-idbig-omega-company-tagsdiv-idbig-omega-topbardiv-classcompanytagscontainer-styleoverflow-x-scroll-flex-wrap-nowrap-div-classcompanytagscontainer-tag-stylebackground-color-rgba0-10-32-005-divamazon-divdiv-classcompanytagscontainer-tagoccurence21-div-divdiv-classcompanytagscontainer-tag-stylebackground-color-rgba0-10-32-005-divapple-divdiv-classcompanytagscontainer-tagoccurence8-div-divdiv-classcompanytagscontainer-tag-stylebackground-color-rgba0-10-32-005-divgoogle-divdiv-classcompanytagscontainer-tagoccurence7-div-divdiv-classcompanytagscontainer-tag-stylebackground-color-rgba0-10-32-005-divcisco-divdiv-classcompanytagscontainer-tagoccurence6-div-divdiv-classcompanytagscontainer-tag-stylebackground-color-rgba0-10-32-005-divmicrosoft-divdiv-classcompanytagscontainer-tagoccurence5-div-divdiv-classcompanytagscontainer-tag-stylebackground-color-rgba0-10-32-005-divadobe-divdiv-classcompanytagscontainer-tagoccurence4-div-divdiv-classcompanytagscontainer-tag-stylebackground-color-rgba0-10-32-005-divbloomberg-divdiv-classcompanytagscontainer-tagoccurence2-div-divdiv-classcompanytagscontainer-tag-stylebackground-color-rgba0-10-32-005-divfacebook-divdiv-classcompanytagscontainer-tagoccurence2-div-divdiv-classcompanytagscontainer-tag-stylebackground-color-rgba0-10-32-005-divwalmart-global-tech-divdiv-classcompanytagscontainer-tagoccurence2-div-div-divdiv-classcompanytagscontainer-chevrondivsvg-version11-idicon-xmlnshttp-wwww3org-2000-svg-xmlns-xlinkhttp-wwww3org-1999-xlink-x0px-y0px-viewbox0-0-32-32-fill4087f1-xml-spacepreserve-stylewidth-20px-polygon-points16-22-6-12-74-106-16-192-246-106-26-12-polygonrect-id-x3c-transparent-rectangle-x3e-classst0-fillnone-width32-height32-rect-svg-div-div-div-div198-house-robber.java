class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int nextD = 0;
        int nextND = 0;
        int res = 0;
        for(int i=n-1;i>=0;i--){
            res = Math.max(nextD,nums[i]+nextND);
            nextND = nextD;
            nextD = res;
        }
        
        return res;
    }
}