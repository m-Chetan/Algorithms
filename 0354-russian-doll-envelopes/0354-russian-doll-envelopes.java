class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> a[0] == b[0] ? b[1]-a[1] : a[0]-b[0]);
        
        int[] heights = new int[envelopes.length];
        
        for(int i=0;i<heights.length;i++) heights[i] = envelopes[i][1];
        
        return lis(heights);
    }
    
    private int lis(int[] heights){
        int prev = 0;
        
        for(int i=1;i<heights.length;i++){
            if(heights[i] > heights[prev]){
                heights[prev+1] = heights[i];
                prev++;
            }
            else{
                int idx = binarySearch(0,prev,heights,heights[i]);
                heights[idx] = heights[i];
            }
        }
        
        return prev+1;
    }
    
    private int binarySearch(int low,int high,int[] nums, int target){
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] >= target) high = mid-1;
            else low = mid+1;
        }
        
        return low;
    }
}