class Solution {
    public int minStartValue(int[] nums) {
        int min = Integer.MAX_VALUE;
        int prefixSum = 0;
        
        for(int num: nums){
            prefixSum += num;
            min = Math.min(min,prefixSum);
        }

        return min<0 ? (-1*min)+1 : 1;
    }
}