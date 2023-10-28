class Solution {
    public int countVowelPermutation(int n) {
        int MOD = 1000000007;
        
        long[] dp = new long[5];
        Arrays.fill(dp,1);
        
        for(int j=1;j<n;j++){
            long a=dp[0], e=dp[1], i=dp[2], o=dp[3], u=dp[4];
            
            dp[0] = (e+u+i)%MOD;
            dp[1] = (a+i)%MOD;
            dp[2] = (e+o)%MOD;
            dp[3] = (i)%MOD;
            dp[4] = (o+i)%MOD;
            
        }
        
        
        long sum = 0;
        for(long e:dp) sum = sum+e;
        
        return (int)(sum%MOD);
    }
}