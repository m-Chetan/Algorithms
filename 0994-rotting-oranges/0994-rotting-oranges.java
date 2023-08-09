class Solution {
    public class Node{
        int row;
        int col;
        int time;
        
        public Node(int row,int col,int time){
            this.row = row;
            this.col = col;
            this.time = time;
        } 
    }
    
    public int orangesRotting(int[][] grid) {
        Queue<Node> q = new ArrayDeque<>(); 
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    q.add(new Node(i,j,0));
                }
            }
        }
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        int maxTime = 0;
        
        int[] adjRow = {-1,0,1,0};  //north west south east 
        int[] adjCol = {0,-1,0,1};
        
        while(q.size()>0){
            Node first = q.remove();
             
            maxTime = Math.max(maxTime,first.time);
            
            for(int i=0;i<4;i++){
                int row = first.row + adjRow[i];
                int col = first.col + adjCol[i];
                if(row>=0 && col>=0 && row<grid.length && col<grid[0].length && visited[row][col] != true && grid[row][col] == 1){
                    q.add(new Node(row,col,first.time+1));
                    visited[row][col] = true; 
                }
            }
        }
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1 && visited[i][j] == false){
                    return -1;
                }
            }
        }
        
        
        return maxTime;
    }
}