class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        
        int mid = (n-1)/2;
        
        int i = mid, j = n-1;
        int res = 0;
        while(i>=0 && j>mid){
            if(2*nums[i] <= nums[j]){
                i--; j--;
                res +=2;
            }
            else i--;
        }
        
        return res;
    }
}