class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<Node>[] graph = generateGraph(n, edges);
        
        int[] neighbors = new int[n];
        
        for(int i=0; i<n; i++){
            int neighborCount = bfs(i,distanceThreshold, graph);
            neighbors[i] = neighborCount;
            //System.out.println(neighbors[i]);
        }
    
        int smallestNeighbor = 0;
        
        int neighborCount = Integer.MAX_VALUE;
        
        for(int i=0; i<n; i++){
            if(neighbors[i] <= neighborCount){
                smallestNeighbor = i;
                neighborCount = neighbors[i];
            }
        }
        
        return smallestNeighbor;
        
    }
    
    private int bfs(int src, int distanceThreshold, ArrayList<Node>[] graph){
        int n = graph.length;
        boolean[] visited = new boolean[n];
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.weight-b.weight);
        pq.add(new Node(src, 0));
        int count = 0;
        
        while(pq.size() > 0){
            Node node = pq.remove();
            if(visited[node.vertex] == true) continue;
            
            visited[node.vertex] = true;
            count++;
            
            for(Node nbr: graph[node.vertex]){
                if(!visited[nbr.vertex] && node.weight+nbr.weight <= distanceThreshold)
                    pq.add(new Node(nbr.vertex, node.weight+nbr.weight));
            }
        }
        
        return count-1;
    }
    
    private ArrayList<Node>[] generateGraph(int n, int[][] edges){
        ArrayList<Node>[] graph = new ArrayList[n];
        
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            
            graph[u].add(new Node(v,w));
            graph[v].add(new Node(u,w));
        }
        
        return graph;
    }
}

class Node{
    int vertex;
    int weight;
    
    public Node(int vertex, int weight){
        this.vertex = vertex;
        this.weight = weight;
    }
}