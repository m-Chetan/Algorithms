class Solution {
    public int findLongestChain(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int maxMeet=0;
        int lim=Integer.MIN_VALUE;
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]>lim){
                maxMeet++;
                lim=intervals[i][1];
            }
        }
        return maxMeet;
    }
}