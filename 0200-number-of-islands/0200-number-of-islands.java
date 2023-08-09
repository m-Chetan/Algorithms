class Solution {
     
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int numOfIslands = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1'){
                    dfs(i,j,grid);
                    numOfIslands++;
                }
            }
        }
        
        return numOfIslands;
    }
    
    private void dfs(int sr,int sc, char[][] grid){
        if(sr<0 || sc<0 || sr>=grid.length || sc>=grid[0].length || grid[sr][sc] == '0') return;
        
        grid[sr][sc] = '0';
        dfs(sr+1,sc,grid);
        dfs(sr,sc+1,grid);
        dfs(sr-1,sc,grid);
        dfs(sr,sc-1,grid);
    }
    
    
    //Number Of Distinct Island Code
    
//     public int numIslands(char[][] grid) {
//         int n = grid.length, m = grid[0].length;
        
//         HashSet<String> set = new HashSet<>();
        
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
                
//                 if(grid[i][j] == '1'){
//                     StringBuilder islandStructure = new StringBuilder('s');
//                     dfs(i,j,grid,islandStructure);
//                     System.out.println(islandStructure);
//                     set.add(new String(islandStructure));
//                 }
//             }
//         }
//         //System.out.println(set);
//         return set.size();
//     }
    
//    private void dfs(int sr,int sc, char[][] grid, StringBuilder structure){
//         if(sr<0 || sc<0 || sr>=grid.length || sc>=grid[0].length || grid[sr][sc] == '0') return;
        
//         grid[sr][sc] = '0';
//         dfs(sr+1,sc,grid,structure.append('d'));
//         dfs(sr,sc+1,grid,structure.append('r'));
//         dfs(sr-1,sc,grid,structure.append('u'));
//         dfs(sr,sc-1,grid,structure.append('l'));
//     }
    
    
}