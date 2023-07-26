class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        
        HashMap<Integer,Integer> endBrickFreq = new HashMap<>();
        
        int highestFreq = 0;
        
        for(List<Integer> widths: wall){
            int lastBrickSum = 0;
            for(int i=0;i<widths.size()-1;i++){
                int brick = widths.get(i);
                lastBrickSum += brick;
                endBrickFreq.put(lastBrickSum,endBrickFreq.getOrDefault(lastBrickSum,0)+1);
                highestFreq = Math.max(highestFreq, endBrickFreq.get(lastBrickSum));
            }
        }
        
        int minCrossed = n- highestFreq;
        
        return minCrossed;
        
    }
}