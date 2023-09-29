class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n];
        
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                int max = 0;
                for(int k=i;k<=j;k++){
                    int left = i-1>=0 ? nums[i-1] : 1;
                    int right = j+1<n ? nums[j+1] : 1;
                    int product = left * nums[k] * right;
                    
                    int leftres = k-1>=i ? dp[i][k-1] : 0;
                    int rightres = k+1<=j ? dp[k+1][j] : 0;
                    
                    max = Math.max(max,product+leftres+rightres);
                    
                }
                
                dp[i][j] = max;
            }
        }
        
        return dp[0][n-1];
    }
}