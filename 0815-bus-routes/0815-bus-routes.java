class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        int n = routes.length;
        
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        
        for(int bus=0;bus<n;bus++){
            for(int j=0; j<routes[bus].length; j++){
                int busStop = routes[bus][j];
                ArrayList<Integer> busno = map.getOrDefault(busStop,new ArrayList<>());
                busno.add(bus);
                map.put(busStop,busno);
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> busStopVis = new HashSet<>();
        HashSet<Integer> busVis = new HashSet<>();
        
        q.add(source);
        int level = 0;
        
        while(q.size()>0){
            int size = q.size();
            
            while(size-->0){
                int stop = q.remove();
                
                if(stop == target) return level;
                
                busStopVis.add(stop);
                
                ArrayList<Integer> buses = map.get(stop);
                
                for(int bus:buses){
                    if(busVis.contains(bus)) continue;
                    for(int busStop: routes[bus]){
                        if(busStopVis.contains(busStop)) continue;
                        q.add(busStop);
                    }
                    busVis.add(bus);
                }
                
                
            }
            
            level++;
        }
        
        return -1;
    }
}