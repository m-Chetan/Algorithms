class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = neededTime.length;
    
        int sum = 0;
        for(int time: neededTime) sum += time;
        
        int res = 0;
        
        int i=0;
        
        while(i<n){
            int max = neededTime[i];
            while(i<n-1 && colors.charAt(i) == colors.charAt(i+1)){
                max = Math.max(max,neededTime[i]);
                i++;
            }
            max = Math.max(max,neededTime[i]);
            
            res += max;
            i++;
        }
        
        return sum-res;
    }
    
    
//     public int minCost(String colors, int[] neededTime) {
//         int n = neededTime.length;
        
//         int res = 0;
        
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         int i=0;
        
//         while(i<n){
//             while(i<n-1 && colors.charAt(i) == colors.charAt(i+1)){
//                 pq.add(neededTime[i]);
//                 i++;
//             }
//             pq.add(neededTime[i]);
            
//             while(pq.size()>1) res += pq.remove();
//             pq.remove();
//             i++;
//         }
        
//         return res;
//     }
}