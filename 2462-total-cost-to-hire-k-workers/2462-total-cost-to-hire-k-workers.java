class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int i=0, j=costs.length-1;
        
        PriorityQueue<Integer> start = new PriorityQueue<>();
        PriorityQueue<Integer> end = new PriorityQueue<>();
        
        long totalCost = 0;
        
        while(k-->0){
            while(start.size()<candidates && i<=j){
                start.add(costs[i++]);
            }
            while(end.size()<candidates && i<=j){
                end.add(costs[j--]);
            }
            
            int s = start.size()>0 ? start.peek() : Integer.MAX_VALUE;
            int e = end.size()>0 ? end.peek() : Integer.MAX_VALUE;
            
            if(s<=e) totalCost += start.remove();
            else totalCost += end.remove();

        }
        
        return totalCost;
    }
}