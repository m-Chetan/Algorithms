class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        getSubsets(0,nums,new ArrayList<>(), res);
        
        return res;
    }
    
    private void getSubsets(int idx, int[] nums, List<Integer> subset,List<List<Integer>> res ){
        if(idx == nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        
        subset.add(nums[idx]);
        getSubsets(idx+1,nums,subset,res);
        subset.remove(subset.size()-1);
        getSubsets(idx+1,nums,subset,res);
    }
}