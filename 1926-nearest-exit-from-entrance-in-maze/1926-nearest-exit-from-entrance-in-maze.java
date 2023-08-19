class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(entrance[0],entrance[1],0));
        maze[entrance[0]][entrance[1]] = '+';
        int[] X = {1,0,-1,0};
        int[] Y = {0,1,0,-1};
        
        while(q.size()>0){
            Node node = q.remove();

            for(int i=0;i<4;i++){
                int newRow = node.row + X[i];
                int newCol = node.col + Y[i];
                
                if(isValid(maze,newRow,newCol)){
                    maze[newRow][newCol] = '+';
                    q.add(new Node(newRow,newCol,node.level+1));
                    if(isExit(newRow,newCol,m,n)) return node.level+1;
                }
                
                
            }
            
        }
        
        return -1;
    }
    
    private boolean isExit(int row, int col,int m,int n){
        if(row==m-1 || col==n-1 || row==0 || col == 0) return true;
        return false;
    }
    
    private boolean isValid(char[][] maze, int row, int col){
        if(row<0 || col<0 || row>=maze.length || col>=maze[0].length || maze[row][col]=='+')
            return false;
        return true;
    }
    
}

class Node{
    int row,col;
    int level;
    public Node(int row, int col,int level){
        this.row = row;
        this.col = col;
        this.level = level;
    }
}