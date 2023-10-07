class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
         int n = m;
         
        for(int i=m-2;i>=0;i--){
            for(int j=0;j<n;j++){
                int min = Integer.MAX_VALUE;
                for(int k=0;k<n;k++){
                    if(k==j) continue;
                    min = Math.min(min,matrix[i+1][k]);
                }
                
                matrix[i][j] += min;
            }
        }
        
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans=Math.min(ans,matrix[0][i]);
        }
        return ans;
    }
}