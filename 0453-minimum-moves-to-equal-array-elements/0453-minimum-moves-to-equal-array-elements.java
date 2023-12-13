class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int e: nums) min = Math.min(min,e);
        int res = 0;
        for(int e:nums) res += e-min;
        return res;
    }
}