class Solution {
    public int countSquares(int[][] matrix) {
        int m=matrix.length, n= matrix[0].length;
        int res = 0;
        
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(matrix[i][j]==0) continue;
                
                int right = j+1<n ? matrix[i][j+1] : 0; 
                int down = i+1<m ? matrix[i+1][j] : 0;
                int diagonal = (i+1<m && j+1<n) ? matrix[i+1][j+1] : 0;
                    
                matrix[i][j] += Math.min(right,Math.min(down,diagonal));
                
                res += matrix[i][j];
               
            }
        }
        
        
        return res;
    }
}