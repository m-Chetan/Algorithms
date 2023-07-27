class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        
        int[][] heights = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                heights[i][j] = matrix[i][j] - '0';
            }
        }
        
        
        int maxArea = 0;
        
        for(int i=0;i<n;i++){
            if(i>0){
                for(int j=0;j<m;j++){
                    if(heights[i][j] != 0) heights[i][j] += heights[i-1][j];
                }
            }
            
            int largestArea = largestRectangleArea(heights,i);
            maxArea = Math.max(maxArea,largestArea);
        }
        
        return maxArea;
    }
    
    private int largestRectangleArea(int[][] heights, int row) {
        int ans = 0;
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        
        for(int col=0; col<=heights[row].length; col++){
            int currVal = (col<heights[row].length) ? heights[row][col] : Integer.MIN_VALUE;
            while(stk.peek() != -1 && currVal < heights[row][stk.peek()]){
                int idx = stk.pop();
                ans = Math.max(ans,heights[row][idx]*(col-stk.peek()-1));
            } 
            stk.push(col);
        }
        
        return ans; 
    }
}