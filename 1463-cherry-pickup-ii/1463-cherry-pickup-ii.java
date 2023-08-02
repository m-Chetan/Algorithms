class Solution {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][][] dp = new int[rows][cols][cols];
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        
        return helper(0,0,cols-1,grid,dp);
    }
    
    private int helper(int r, int c1, int c2, int[][] grid,int[][][] dp){
        
        if(c1<0 || c1>=grid[0].length || c2<0 || c2>=grid[0].length) return -1000000;
        
        if(dp[r][c1][c2] != -1) return dp[r][c1][c2];
        
        if(r == grid.length-1){
            if(c1==c2) return grid[r][c1];
            return grid[r][c1] + grid[r][c2];
        }
        
        int max = -100000;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int res = helper(r+1,c1+i,c2+j,grid,dp);
                if(c1==c2){
                    res += grid[r][c1];
                }
                else{
                    res += grid[r][c1] + grid[r][c2];
                }
                max = Math.max(max,res);
            }
        }
        dp[r][c1][c2] = max;
        return max;
    }
}