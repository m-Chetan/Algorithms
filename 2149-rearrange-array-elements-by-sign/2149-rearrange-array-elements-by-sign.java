class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int j=0, k=1;
        
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                res[k] = nums[i];
                k+=2;
            }
            else{
                res[j] = nums[i];
                j+=2;
            }
        }
        
        return res;
    }
}