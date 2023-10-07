class Solution {
    public int minimumDifference(int[] nums) {
        int S = 0;
        for(int num: nums) S += num;
        
        int half = nums.length/2;
        
        HashMap<Integer,List<Integer>> leftSet = new HashMap<>();
        HashMap<Integer,List<Integer>> rightSet = new HashMap<>();
        
        getSubsetSum(0,half,nums,leftSet);
        getSubsetSum(half,half,nums,rightSet);

        int ans = Integer.MAX_VALUE;
        
        for(int key: leftSet.keySet()){
            List<Integer> left = leftSet.get(key);
            Collections.sort(left);
            
            List<Integer> right = rightSet.get(half-key);
            Collections.sort(right);
            
            int low = 0, high = right.size()-1;
            
            while(low<left.size() && high>=0){
                int diff = 2*(left.get(low) + right.get(high)) - S;
                
                if(diff == 0) return 0;
                if(diff < 0) low++;
                else high--;
                
                ans = Math.min(ans,Math.abs(diff));
            }
        }
        
        return ans;
    }
    
    private void getSubsetSum(int idx, int N, int[] nums, HashMap<Integer,List<Integer>> map){
        
        for(int i=0; i<(1<<N); i++){
            int sum = 0;
            int count = 0;
            for(int j=0;j<N;j++){
                if((i & (1<<j)) != 0){
                    sum += nums[N-j-1+idx];
                    count++;
                }
            }
            
            if(!map.containsKey(count)) map.put(count,new ArrayList<>());
            map.get(count).add(sum);
        }
    }
}