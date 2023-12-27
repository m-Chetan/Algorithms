class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int MOD = 1000000007;
    
        long[][] dp = new long[n+1][target+1];
        
        dp[0][0] = 1;
        for(int i=1;i<n+1;i++){
            for(int j=i;j<=target;j++){
                if(j>k*i) continue;
        
                for(int m=1;m<=k;m++){
                    if(j-m >=0) dp[i][j] = (dp[i][j]+dp[i-1][j-m])%MOD;
                }
 
            }
        }
        
        return (int) (dp[n][target]);
    }
    
    //recursion giving TLE
//     public int numRollsToTarget(int n, int k, int target) {
//         if(n==1){
//             if(target>k) return 0;
//             return 1;
//         }
        
//         int res = 0;
//         for(int i=1;i<=k;i++){
//             res += numRollsToTarget(n-1,k,target-k);
//         }
        
        
//         return res;
//     }
}