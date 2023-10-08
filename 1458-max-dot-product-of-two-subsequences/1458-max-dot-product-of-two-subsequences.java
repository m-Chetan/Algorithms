class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] memo = new int[nums1.length+1][nums2.length+1];
        for(int i=0;i<memo.length;i++){
            Arrays.fill(memo[i],Integer.MIN_VALUE);
        }
        
        return helper(0,0,nums1,nums2,memo);
    }
    
    private int helper(int i, int j, int[] nums1, int[] nums2, int[][] memo){
        if(i==nums1.length-1 && j==nums2.length-1) return memo[i][j] = nums1[i]*nums2[j];
        
        if(i==nums1.length || j== nums2.length) return Integer.MIN_VALUE;
    
        if(memo[i][j] != Integer.MIN_VALUE) return memo[i][j];
        
        int x = helper(i+1,j+1,nums1,nums2,memo);
        x = (nums1[i]*nums2[j]) + Math.max(x,0);
        int y = helper(i+1,j,nums1,nums2,memo);
        
        int z = helper(i,j+1,nums1,nums2,memo);
        
        return memo[i][j] = Math.max(x,Math.max(y,z));
        
        
    }
}