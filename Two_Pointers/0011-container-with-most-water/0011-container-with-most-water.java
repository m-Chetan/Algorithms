class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxWater = 0;
        int i = 0, j = n-1;
        
        while(i<j){
            if(height[i]<=height[j]){
                maxWater = Math.max(maxWater,height[i]*(j-i));
                i++;
            }
            else{
                maxWater = Math.max(maxWater,height[j]*(j-i));
                j--;
            }
        }
        
        return maxWater;
    }
}