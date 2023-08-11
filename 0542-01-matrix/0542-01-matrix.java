class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int maxDist = mat.length + mat[0].length;
        
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] == 0) continue;
                int top = (i-1) >=0 ? mat[i-1][j] : maxDist;
                int left = (j-1) >=0 ? mat[i][j-1] : maxDist;
                mat[i][j] = Math.min(top,left) + 1;
            }
        }
         
        for(int i=mat.length-1;i>=0;i--){
            for(int j=mat[0].length-1;j>=0;j--){
                if(mat[i][j] == 0) continue;
                int down = (i+1) < mat.length ? mat[i+1][j] : maxDist;
                int right = (j+1) < mat[0].length ? mat[i][j+1] : maxDist;
                mat[i][j] = Math.min(mat[i][j], Math.min(down,right)+1);
            }
        }
        
        return mat;
        
    }
    
    
//     class Node{
//         int row,col,dist;
//         public Node(int row, int col, int dist){
//             this.row = row;
//             this.col = col;
//             this.dist = dist;
//         }
//     }
    
//     public int[][] updateMatrix(int[][] mat) {
//         int[][] ans = new int[mat.length][mat[0].length];
        
//         Queue<Node> q = new ArrayDeque<>();
        
//         for(int i=0;i<mat.length;i++){
//             for(int j=0;j<mat[0].length;j++){
//                 if(mat[i][j] == 0) q.add(new Node(i,j,0));
//             }
//         }
        
//         int[] X = {1,0,-1,0};
//         int[] Y = {0,1,0,-1};
        
//         while(q.size()>0){
//             Node node = q.remove();
            
//             if(ans[node.row][node.col] != 0){
//                 ans[node.row][node.col] = Math.min(ans[node.row][node.col],node.dist);
//                 continue;
//             }
//             ans[node.row][node.col] = node.dist;
//             for(int i=0;i<4;i++){
//                 int r = node.row + X[i];
//                 int c = node.col + Y[i];
                
//                 if(r>=0 && r<mat.length && c>=0 && c<mat[0].length){
//                     if(mat[r][c] != 0 && ans[r][c] == 0){
//                         q.add(new Node(r,c,node.dist+1));
//                     }
//                 }
//             }
            
//         }
        
//         return ans;
//     }
}