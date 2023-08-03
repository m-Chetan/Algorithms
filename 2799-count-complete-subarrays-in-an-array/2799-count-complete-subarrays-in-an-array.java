class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) set.add(num);
        
        int distinct = set.size();
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int start = 0, res = 0;
        
        for(int end = 0;end<nums.length;end++){
            map.put(nums[end],map.getOrDefault(nums[end],0)+1);
            
            while(map.size() == distinct){
                map.put(nums[start],map.get(nums[start])-1);
                if(map.get(nums[start]) == 0) map.remove(nums[start]);
                start++;
            }
            res += start;
        }
        
        return res;
    }
}