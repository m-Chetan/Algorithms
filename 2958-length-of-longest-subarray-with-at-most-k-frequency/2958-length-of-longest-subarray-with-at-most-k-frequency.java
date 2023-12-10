class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        
        int res = 0;
        int start = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int end=0; end<n; end++){
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            
            while( map.get(nums[end]) > k){
                map.put(nums[start], map.get(nums[start])-1);
                if(map.get(nums[start])==0) map.remove(nums[start]);
                start++;
            }
            
            res = Math.max(res, end-start+1);
        }
        
        
        return res;
    }
}