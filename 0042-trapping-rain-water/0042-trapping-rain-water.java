class Solution {
    //Take two pointer i=0 and j=n-1 
    // if height[i] is less than height of j then water will contain in min height of both
    // then subtract the curr height from the min height
    // similary for right side
    
    public int trap(int[] height) {
        int water = 0;
        int i = 0, j = height.length-1;
        int leftMax = 0, rightMax = 0;
        
        while(i<j){
            if(height[i] <= height[j]){
                if(height[i] > leftMax) leftMax = height[i];
                water += Math.min(leftMax,height[j]) - height[i];
                i++;
            }
            else{
                if(height[j] > rightMax) rightMax = height[j];
                water += Math.min(rightMax,height[i]) - height[j];
                j--;
            }
        }
        
        return water;
    }
}