class Solution {
    public int maximalSquare(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        int[][] matrix = new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = grid[i][j]-'0';
            }
        }
        
        
        int maxSquare = 0;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(matrix[i][j] == 0) continue;
                if(i==m-1 || j==n-1) maxSquare = Math.max(maxSquare,matrix[i][j]);
                else{
                    matrix[i][j] += Math.min(matrix[i+1][j], Math.min(matrix[i][j+1],matrix[i+1][j+1]));
                    
                    maxSquare = Math.max(maxSquare,matrix[i][j]);
                }
            }
        }
        
        return maxSquare*maxSquare;
    }
}