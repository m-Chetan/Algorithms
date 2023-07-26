class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(startFuel >= target) return 0;
        
        int n = stations.length;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int startPoint = 0, maxFuel = startFuel;
        int stops = 0;
        
        while(maxFuel < target){
            while(startPoint < n && stations[startPoint][0] <= maxFuel){
                pq.add(stations[startPoint][1]);
                startPoint++;
            }    
            
            if(pq.size() == 0) return -1;
            maxFuel += pq.remove();
            stops++;
        }
        
        return stops;
    }
}