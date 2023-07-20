class Solution {
    private void combinationSum(int idx,int[] candidates,ArrayList<Integer> combination, List<List<Integer>> ans, int target ){
        if(target<0) return;
        if(target == 0){
            ans.add(new ArrayList<>(combination));
            return;
        }
        
        for(int i=idx;i<candidates.length;i++){
            if(i!=idx && candidates[i] == candidates[i-1]) continue;
            combination.add(candidates[i]);
            combinationSum(i+1,candidates,combination,ans,target-candidates[i]);
            combination.remove(combination.size()-1);
        }
        
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        combinationSum(0,candidates,new ArrayList<>(),ans,target);
        return ans;
    }
}