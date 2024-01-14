class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> freq = new HashMap<>();
        
        int maxFreq = 0;
        
        for(int ele: nums){
            freq.put(ele,freq.getOrDefault(ele,0)+1);
            maxFreq = Math.max(maxFreq,freq.get(ele));
        }
        
        int res = 0;
        for(int key: freq.keySet()){
            if(freq.get(key) == maxFreq){
                res += maxFreq;
            }
        }
        
        return res;
    }
}