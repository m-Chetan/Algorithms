class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] Job = new int[n][3];
        
        for(int i=0;i<n;i++){
            Job[i][0] = startTime[i];
            Job[i][1] = endTime[i];
            Job[i][2] = profit[i];
        }
        
        Arrays.sort(Job,(a,b) -> a[1]-b[1]);
        
        TreeMap<Integer,Integer> map = new TreeMap<>();
        map.put(0,0);
        
        int maxProfit = 0;
        
        for(int i=0;i<n;i++){
            Integer endingBefore = map.floorKey(Job[i][0]);
     
            int prof = Job[i][2];
            prof += map.get(endingBefore);
            if(prof>map.get(map.lastKey()))
                map.put(Job[i][1],prof);
            maxProfit = Math.max(maxProfit,prof);
        }
        
        return maxProfit;
    }
}