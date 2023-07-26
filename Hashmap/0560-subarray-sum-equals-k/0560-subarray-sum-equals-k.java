class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        HashMap<Integer,Integer> sumFreq = new HashMap<>();
        sumFreq.put(0,1);
        
        int prefixSum = 0;
    
        for(int i=0;i<n;i++){
            prefixSum += nums[i];
            
            if(sumFreq.containsKey(prefixSum-k))
                ans += sumFreq.get(prefixSum-k);
            
            sumFreq.put(prefixSum,sumFreq.getOrDefault(prefixSum,0)+1);
        }
        
        return ans;
    }
}