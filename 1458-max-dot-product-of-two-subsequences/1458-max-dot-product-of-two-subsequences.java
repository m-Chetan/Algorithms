class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i=0;i<=m;i++){
            Arrays.fill(dp[i],Integer.MIN_VALUE);
        }
        
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int x = (nums1[i]*nums2[j]) + Math.max(dp[i+1][j+1], 0);
                int y = dp[i+1][j];
                int z = dp[i][j+1];
                
                dp[i][j] = Math.max(x,Math.max(y,z));
            }
        }
        
        return dp[0][0];
    }
    
}