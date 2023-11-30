class Solution {
    List<List<String>> ans;
    Set<Integer> colSet;
    Set<Integer> leftDiagonal;
    Set<Integer> rightDiagonal;
    
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        colSet = new HashSet<>(); 
        leftDiagonal = new HashSet<>();
        rightDiagonal = new HashSet<>();
        
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++) Arrays.fill(board[i],'.');
           
        solve(0,board, colSet, leftDiagonal, rightDiagonal);
         
        return ans;
    }
    
    private void solve(int row, char[][] board,Set<Integer> colSet,Set<Integer> leftDiagonal,Set<Integer> rightDiagonal){
    
        if(row == board.length){
            List<String> res = new ArrayList<>();
            for(int i=0;i<board.length;i++){
                res.add(new String(board[i]));
            }
            ans.add(res);
            return;
        }
        
        for(int col=0;col<board[0].length;col++){
            if(!colSet.contains(col) && !leftDiagonal.contains(col-row) && !rightDiagonal.contains(row+col)){
                colSet.add(col);
                leftDiagonal.add(col-row);
                rightDiagonal.add(row+col);
                
                board[row][col] = 'Q';
                solve(row+1, board, colSet, leftDiagonal, rightDiagonal);
                board[row][col] = '.';
                
                colSet.remove(col);
                leftDiagonal.remove(col-row);
                rightDiagonal.remove(row+col);
            }
        }
    }
    
    
}