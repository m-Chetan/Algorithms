class Solution {
    //Recursive Solution using swaps
        public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        getPermutations(nums,res, 0);
        
        return res;
    }
    
    private void getPermutations(int[] nums, List<List<Integer>> res, int idx){
        
        if(idx == nums.length){
            List<Integer> permutation = new ArrayList<>();
            for(int num: nums) permutation.add(num);
            res.add(permutation);
            return;
        }
        
        for(int i=idx;i<nums.length;i++){
            swap(nums,idx, i);
            getPermutations(nums,res,idx+1);
            swap(nums,idx, i);   
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    
    
    //Recursive solution using boolean visited array
    
//     public List<List<Integer>> permute(int[] nums) {
//         boolean[] visited = new boolean[nums.length];
//         List<List<Integer>> res = new ArrayList<>();
        
//         getPermutations(nums,visited,res,new ArrayList<>());
        
//         return res;
//     }
    
//     private void getPermutations(int[] nums, boolean[] vis, List<List<Integer>> res,List<Integer> permutation){
        
//         if(permutation.size() == nums.length){
//             res.add(new ArrayList<>(permutation));
//             return;
//         }
        
//         for(int i=0;i<nums.length;i++){
//             if(vis[i] == false){
//                 vis[i] = true;
//                 permutation.add(nums[i]);
//                 getPermutations(nums,vis,res,permutation);
//                 permutation.remove(permutation.size()-1);
//                 vis[i] = false;
//             }
//         }
//     }
}