class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0,candidates,target,res,new ArrayList<>());
 
        return res;
    }
    
    private void helper(int idx, int[] candidates, int target, List<List<Integer>> res, List<Integer> subset){
        if(target<0) return;
        
        if(target==0){
            res.add(new ArrayList<>(subset));
            return;
        }
        
        for(int i=idx;i<candidates.length;i++){
            subset.add(candidates[i]);
            helper(i,candidates,target-candidates[i],res,subset);
            subset.remove(subset.size()-1);
        }
        
        
    }
}