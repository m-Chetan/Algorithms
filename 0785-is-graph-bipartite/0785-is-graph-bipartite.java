class Solution {
    class Node{
        int vertex, level;
        public Node(int vertex,int level){
            this.vertex = vertex;
            this.level = level;
        }
    }
    
    public boolean isBipartite(int[][] graph) {     
        int n = graph.length, m = graph[0].length;
        int[] visited = new int[n];
        Arrays.fill(visited,-1);
        
        for(int i=0;i<n;i++){
            if(visited[i] == -1){
                boolean isBipartite = bfs(i,graph,visited);
                    
                if(isBipartite == false) return false;
            }
        }
        
        return true;
    }
    
    private boolean bfs(int src,int[][] graph, int[] visited){
       
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(src,0));
        
        while(q.size() > 0){
            Node node = q.remove();
            
            if(visited[node.vertex] != -1 && visited[node.vertex]%2 != node.level%2) return false;
            
            visited[node.vertex] = node.level;
            for(int i=0;i<graph[node.vertex].length;i++){
                if(visited[graph[node.vertex][i]] == -1){
                    q.add(new Node(graph[node.vertex][i],node.level+1));
                }
            }
        }
        
        return true;    
    }
}