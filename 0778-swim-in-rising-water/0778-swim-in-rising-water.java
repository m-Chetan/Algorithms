class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int res = grid[0][0];
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        pq.add(new Node(0,0,grid[0][0]));
        
        int[] X = {0,1,0,-1};
        int[] Y = {1,0,-1,0};
        
        while(pq.size()>0){
            Node node = pq.remove();
        
            res = Math.max(res,node.val);
            if(node.row == n-1 && node.col == n-1){
                return res;
            }
            grid[node.row][node.col] = -1;
            
            for(int i=0;i<4;i++){
                int adjRow = node.row + X[i];
                int adjCol = node.col + Y[i];
                
                if(isValidCell(adjRow,adjCol,grid) && grid[adjRow][adjCol] != -1){
                    pq.add(new Node(adjRow,adjCol,grid[adjRow][adjCol]));
                }
            }
        }
        
        return -1;
    }
    
    private boolean isValidCell(int row, int col, int[][] grid){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length) return false;
        return true;
    }
}

class Node{
    int row;
    int col;
    int val;
    public Node(int row, int col, int val){
        this.row = row;
        this.col = col;
        this.val = val;
    }
}