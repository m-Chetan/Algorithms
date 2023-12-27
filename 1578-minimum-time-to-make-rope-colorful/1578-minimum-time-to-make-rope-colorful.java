class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = neededTime.length;
        
        int res = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i=0;
        
        while(i<n){
            while(i<n-1 && colors.charAt(i) == colors.charAt(i+1)){
                pq.add(neededTime[i]);
                i++;
            }
            pq.add(neededTime[i]);
            
            while(pq.size()>1) res += pq.remove();
            pq.remove();
            i++;
        }
        
        return res;
    }
}