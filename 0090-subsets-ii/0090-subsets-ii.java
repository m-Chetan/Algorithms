class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(0,nums,res,new ArrayList<>());
        return res;
    }
    
    private void helper(int idx, int[] nums,List<List<Integer>> res, List<Integer> subset){
        res.add(new ArrayList<>(subset));

        for(int i=idx;i<nums.length;i++){
            if(i!=idx && nums[i]==nums[i-1]) continue;
            subset.add(nums[i]);
            helper(i+1,nums,res,subset);
            subset.remove(subset.size()-1);
        }
        
    }
}