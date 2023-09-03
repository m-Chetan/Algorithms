class Solution {
    public int uniquePaths(int m, int n) {
        //Combination
        // Number of right and down move from start to end can be m+n-2
        // take m+n-2 C m-1 or m+n-2 C n-1
        
        double res = 1;
        int N = m+n-2;
        int r = m-1;
        for(int i=1;i<=r;i++){
            res = res*(N-r+i)/i;
        }
        return (int)res;
        
        //using Dp
//         int[][] dp = new int[m][n];
        
//         for(int i=m-1;i>=0;i--){
//             for(int j=n-1;j>=0;j--){
//                 if(i == m-1 || j == n-1){
//                     dp[i][j] = 1;
//                 }
//                 else{
//                     dp[i][j] = dp[i+1][j] + dp[i][j+1];
//                 }
//             }
//         }
        
//         return dp[0][0];
        
        
        //using recurion but TLE 
//         if(m==1 && n==1) return 1;
        
//         if(m<=0 || n<=0) return 0;
        
//         int right = uniquePaths(m,n-1); 
//         int down  = uniquePaths(m-1,n);
            
//         return right+down;
        
    }
}