class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        HashMap<Integer,Integer> sumFreq = new HashMap<>();
        sumFreq.put(0,1);
        
        int prefixSum = 0;
    
        for(int i=0;i<n;i++){
            prefixSum += nums[i];
            
            int remainder = (prefixSum%k +k) %k;
            
            if(sumFreq.containsKey(remainder))
                ans += sumFreq.get(remainder);
            
            sumFreq.put(remainder,sumFreq.getOrDefault(remainder,0)+1);
        }
        
        return ans;
    }
}