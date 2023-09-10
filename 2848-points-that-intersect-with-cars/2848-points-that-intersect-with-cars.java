class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int n = nums.size();
        Collections.sort(nums,(a,b)->a.get(0)-b.get(0));
        
        int start = nums.get(0).get(0);
        int end = nums.get(0).get(1);
        
        int res = 0;
        
        for(int i=1; i<n; i++){
            if(nums.get(i).get(0)<=end){
                start = Math.min(start,nums.get(i).get(0));
                end = Math.max(end,nums.get(i).get(1));
            }
            else{
                res += end-start+1;
                start = nums.get(i).get(0);
                end = nums.get(i).get(1);
            }
        }
        
        res += end-start+1;
        
        return res;
    }
}