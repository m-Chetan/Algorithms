class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg = Integer.MIN_VALUE;
        double sum = 0;
        int start = 0;
        for(int i=0;i<nums.length;i++){
            if(i>=k){
                maxAvg = Math.max(maxAvg,sum/k);
                sum -= nums[start];
                start++;
            }
            sum += nums[i];
        }
        maxAvg = Math.max(maxAvg,sum/k);
        return maxAvg;
    }
}