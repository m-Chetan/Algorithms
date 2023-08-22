class Solution {
    public int snakesAndLadders(int[][] board) {
        
        int n = board.length*board.length; // n = total squares on the board
        
        int i = board.length - 1; // i and j to iterate through the board
        int j = 0;
        boolean flag = true; //For switching between even and odd rows.
        int[] positions = new int[n];
        int index = 0;
        while(index < n){
            positions[index] = board[i][j];
            index++;
            j = flag ? j + 1 : j - 1;
            if(j == board.length){ //Switch if at the edge 
                j--;
                i--;
                flag = !flag;
            }else if(j == -1){ //Switch if at the edge
                j++;
                i--;
                flag = !flag;
            }
        }
        boolean[] visited = new boolean[n]; //Keeping track of visited nodes during Breadth First Search.
        Queue<Integer> q = new LinkedList<>();  
        int start = positions[0] > -1 ? positions[0] - 1: 0; //Start position is the destination of the first square, or 0 if square is not a ladder or snake 
        q.offer(start);
        visited[start] = true;
        int moves = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(i = 0; i < size; i++){
                int curr = q.poll();
                if(curr == n - 1){ //If current square is the last square return total number of moves
                    return moves;
                }
                for(int next = curr + 1; next <= Math.min(curr + 6, n - 1); next++){ //Adding all the next possible squares to the queue
                    int pos = positions[next] > -1 ? positions[next] - 1 : next;
                    if(!visited[pos]){
                        visited[pos] = true;
                        q.offer(pos);
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}