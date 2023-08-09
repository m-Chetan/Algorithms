//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        
        HashSet<String> set = new HashSet<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(grid[i][j] == 1){
                    StringBuilder islandStructure = new StringBuilder('s');
                    dfs(i,j,grid,islandStructure);
                    set.add(new String(islandStructure));
                }
            }
        }
        
        return set.size();
    }
    
    private void dfs(int sr,int sc, int[][] grid, StringBuilder structure){
        if(sr<0 || sc<0 || sr>=grid.length || sc>=grid[0].length || grid[sr][sc] == 0) return;
        
        grid[sr][sc] = 0;
        dfs(sr+1,sc,grid,structure.append('d'));
        dfs(sr,sc+1,grid,structure.append('r'));
        dfs(sr-1,sc,grid,structure.append('u'));
        dfs(sr,sc-1,grid,structure.append('l'));
    }
}
