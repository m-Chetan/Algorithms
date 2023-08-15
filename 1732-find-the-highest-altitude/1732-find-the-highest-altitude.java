class Solution {
    public int largestAltitude(int[] gain) {
        int prefixSum = 0;
        int maxHeight = 0;
        
        for(int num:gain){
            prefixSum += num;
            maxHeight = Math.max(maxHeight,prefixSum);
        }
        
        return maxHeight;
    }
}