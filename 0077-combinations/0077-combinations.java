class Solution {
     public void combinations(int n, int k,int currItem, List<Integer> combination,List<List<Integer>> ans){
        if(combination.size() == k){
            ans.add(new ArrayList<>(combination));
            return;
        }

        for(int i=currItem;i<=n;i++){
            combination.add(i);
            combinations(n,k,i+1,combination,ans);
            combination.remove(combination.size()-1);
        }
    }
    
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        combinations(n,k,1,new ArrayList<>(),ans);
        return ans;
    }
}