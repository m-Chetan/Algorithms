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
        boolean[] visited = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(visited[i] == false){
                boolean isBipartite = bfs(i,graph,visited);
                    
                if(isBipartite == false) return false;
            }
        }
        
        return true;
    }
    
    private boolean bfs(int src,int[][] graph, boolean[] visited){
        HashSet<Integer> even = new HashSet<>();
        HashSet<Integer> odd = new HashSet<>();
        
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(src,0));
        
        while(q.size() > 0){
            Node node = q.remove();
            
            visited[node.vertex] = true;
            
            if(node.level == 0){
                if(odd.contains(node.vertex)) return false;
                even.add(node.vertex);
                for(int i=0;i<graph[node.vertex].length;i++){
                    if(visited[graph[node.vertex][i]] == false){
                        q.add(new Node(graph[node.vertex][i],1));
                    }
                }
            }
            
            if(node.level == 1){
                if(even.contains(node.vertex)) return false;
                odd.add(node.vertex);
                for(int i=0;i<graph[node.vertex].length;i++){
                    if(visited[graph[node.vertex][i]] == false){
                        q.add(new Node(graph[node.vertex][i],0));
                    }
                }
            }
        }
        
        return true;    
    }
}