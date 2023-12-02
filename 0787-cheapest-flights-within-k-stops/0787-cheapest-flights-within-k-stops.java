class Node{
    int vtx,price,stops;
    
    public Node(int vtx, int price, int stops){
        this.vtx = vtx;
        this.price = price;
        this.stops = stops;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Node>[] graph = new ArrayList[n];
        
        for(int i=0;i<n;i++) graph[i] = new ArrayList<>();
        
        for(int i=0;i<flights.length;i++){
            graph[flights[i][0]].add(new Node(flights[i][1],flights[i][2],0));
        }
        
        int[] cost = new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[src] = 0;
        
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(src,0,0));
    
        while(q.size()>0){
            Node node = q.remove();
            
            if(node.price < cost[node.vtx] && node.stops-1<=k) cost[node.vtx] = node.price;
            
            for(Node nbr: graph[node.vtx]){
                if(node.price+nbr.price < cost[nbr.vtx] && node.stops-1<=k){
                    q.add(new Node(nbr.vtx, node.price+nbr.price, node.stops+1));
                }
            }
            
            
        }
        
        
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}