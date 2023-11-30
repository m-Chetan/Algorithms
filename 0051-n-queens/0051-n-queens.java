class Solution {
    List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++) Arrays.fill(board[i],'.');
           
        solve(0,board);
         
        return ans;
    }
    
    private void solve(int row, char[][] board){
    
        if(row == board.length){
            List<String> res = new ArrayList<>();
            for(int i=0;i<board.length;i++){
                res.add(new String(board[i]));
            }
            ans.add(res);
            return;
        }
        
        for(int col=0;col<board[0].length;col++){
            if(isQueenSafe(row,col,board)){
                board[row][col] = 'Q';
                solve(row+1,board);
                board[row][col] = '.';
            }
        }
    }
    
    private boolean isQueenSafe(int row, int col, char[][] board){
        for(int i=0;i<row;i++){
            if(board[i][col] == 'Q') return false;
        }
        
        for(int i=0;i<col;i++){
            if(board[row][i] == 'Q') return false;
        }
        
        int i = row, j = col;
        while(i >= 0 && j >= 0){
            if(board[i][j] == 'Q') return false;

            i--; j--;
        }
        
        i=row; j=col;
        while(i>=0 && j<board.length){
            if(board[i][j]=='Q') return false;
            i--; j++;
        }
        
        return true;
    }
    
    
}