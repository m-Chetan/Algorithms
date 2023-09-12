class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        
        List<Integer> res = new ArrayList<>();
        int count = 0; 
        
        int lt=0, tt=0, lr=m-1, tr=n-1;
        
        while(count<m*n){
            for(int i=tt;i<=tr;i++){
                res.add(matrix[lt][i]);
                count++;
            }
            if(count==m*n) break;
            lt++;
            for(int i=lt;i<=lr;i++){
                res.add(matrix[i][tr]);
                count++;
            }
            if(count==m*n) break;
            tr--;
            for(int i=tr;i>=tt;i--){
                res.add(matrix[lr][i]);;
                count++;
            }
            if(count==m*n) break;
            lr--;
            for(int i=lr;i>=lt;i--){
                res.add(matrix[i][tt]);
                count++;
            }
            if(count==m*n) break;
            tt++;
        }
        
        return res;
    }
}