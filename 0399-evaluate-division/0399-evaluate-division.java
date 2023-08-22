class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = values.length;
        
        Map<String,List<Pair>> graph = new HashMap<>();
        
        for(int i=0; i<n; i++){
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double wt = values[i];
            
            List<Pair> nbrs = graph.getOrDefault(u,new ArrayList<>());
            nbrs.add(new Pair(v,wt));
            graph.put(u,nbrs);
            
            List<Pair> adjNbrs = graph.getOrDefault(v,new ArrayList<>());
            adjNbrs.add(new Pair(u,1/wt));
            graph.put(v,adjNbrs);
            
        }
        double[] res = new double[queries.size()];

        for(int i=0;i<queries.size();i++){
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);
            Set<String> visited = new HashSet<>();
            if(!graph.containsKey(src) || !graph.containsKey(dest)) res[i]=-1;
            else{
                double ans = dfs(src,dest,graph,visited);
                if(ans<=0) ans = -1; 
                res[i] = ans;
            }
        }
        
        return res;
    }
    
    private double dfs(String src, String dest, Map<String,List<Pair>> graph, Set<String> visited){
        if(src.equals(dest)){
            return 1;
        }
        
        visited.add(src);
        double res = 0;
        for(Pair pair: graph.get(src)){
            if(!visited.contains(pair.nbr)){
                double ans = dfs(pair.nbr,dest,graph,visited);
                res = Math.max(res, pair.wt*ans);
            }
        }
        
        return res;
    }
}

class Pair{
    String nbr;
    double wt;
    public Pair(String nbr, double wt){
        this.nbr = nbr;
        this.wt = wt;
    }
}