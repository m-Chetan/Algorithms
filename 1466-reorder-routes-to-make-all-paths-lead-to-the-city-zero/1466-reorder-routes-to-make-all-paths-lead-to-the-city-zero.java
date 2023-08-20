class Solution {
    public int minReorder(int n, int[][] connections) {
        //Create graph for each node there can be 2 neighbors
        //one that can be reached, lets say 1 if reachable 
        //one that can't be lets say 0
        // Graph(nbr,reach) reach -> 1 or 0
        
        ArrayList<int[]>[] graph = new ArrayList[n];
        
        for(int i=0;i<n;i++) graph[i] = new ArrayList<>();
        
        for(int[] conn: connections){
            int u = conn[0], v = conn[1];
            graph[u].add(new int[]{v,1});   // 1 means reachable
            graph[v].add(new int[]{u,0});   // 0 means unreachable
        }
        
        //start BFS from 0th node if neighbor is reachable i.e 1 then increment our result
        
        int res = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        while(q.size()>0){
            int node = q.remove();
            if(visited[node] == true) continue;         //If already visited then continue 
            visited[node] = true;                       //mark node as visited
            
            for(int[] nbr: graph[node]){
                if(visited[nbr[0]] == false){          //Add unvisited nbr to queue
                    q.add(nbr[0]);
                    
                    if(nbr[1]==1) res++;                //If I can reach to nbr my nbr can't reach me 
                                                        //since there are only one way roads present
                }
            }
        }
        
        return res;
        
    }
}