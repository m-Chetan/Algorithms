class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
         int n = m;
         
        for(int i=m-2;i>=0;i--){
            PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.val - b.val);
            
            for(int j=0;j<n;j++) pq.add(new Node(i+1,j,matrix[i+1][j]));
            
            for(int j=0;j<n;j++){
                Node min = pq.peek();
                if(min.j==j){
                    Node top = pq.remove();
                    min = pq.peek();
                    pq.add(top);
                }
                
                matrix[i][j] += min.val;
                
            }
        }
        
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans=Math.min(ans,matrix[0][i]);
        }
        return ans;
    }
}

class Node{
    int i,j,val;
    
    public Node(int i, int j, int val){
        this.i = i;
        this.j = j;
        this.val = val;
    }
}