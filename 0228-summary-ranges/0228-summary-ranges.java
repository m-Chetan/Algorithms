class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> res = new ArrayList<>();
        if(n==0) return res;
        int start = 0;
        
        for(int end=1;end<n;end++){
            if(nums[end] == nums[end-1]+1) continue;
            
            String range = start == end-1 ? nums[start]+"" : (nums[start] +"->" + nums[end-1]);
            res.add(range);
            start = end;
        }
        
        String range = start == n-1 ? nums[start]+"" : (nums[start] +"->" + nums[n-1]);
        res.add(range);
        
        return res;
    }
}