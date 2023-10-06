class Solution {
    public int integerBreak(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        int[] dp = new int[n+1];
        dp[2]=2;
        dp[3]=3;
        for(int i=4;i<=n;i++){
            
            int maxProd = 1;
            for(int j=(i+1)/2;j>=2;j--){
                maxProd = Math.max(maxProd,j*dp[i-j]);
            }
            dp[i] = maxProd;
        }
        
        return dp[n];
    }
}