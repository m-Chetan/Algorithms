class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int[][] res = new int[n/3][3];
        
        Arrays.sort(nums);
        
        int idx = 0;
        
        for(int i=0;i<=n-3;i=i+3){
            int l = 0;
            res[idx][l] = nums[i];
            for(int j=i+1;j<i+3;j++){
                if(nums[j]-nums[i] >k) return new int[][]{};
                l++;
                res[idx][l] = nums[j];
                    
            }
            idx++;
        }
        
        
        return res;
    }
}