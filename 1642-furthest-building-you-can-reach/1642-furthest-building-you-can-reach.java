class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        //Jaise hi chadan aayega hum utna distance priority queue me daal dege meaning 1 ladder hum use kar sakte
        //Jaise hi priority queue ki size ladders se badhi hogi meaning ladders khatam
        //Then hum pq me se pehle chota distance nikalege aur bricks use karege 
        //bricks saari khtam too vo index last hoga
        
        for(int i=0; i<n-1; i++){
            int dist = heights[i+1] - heights[i];
            
            if(dist>0) pq.add(dist);
            
            if(pq.size()>ladders) bricks -= pq.poll();
            
            if(bricks<0) return i;
        }
        
        return n-1;
    }
}