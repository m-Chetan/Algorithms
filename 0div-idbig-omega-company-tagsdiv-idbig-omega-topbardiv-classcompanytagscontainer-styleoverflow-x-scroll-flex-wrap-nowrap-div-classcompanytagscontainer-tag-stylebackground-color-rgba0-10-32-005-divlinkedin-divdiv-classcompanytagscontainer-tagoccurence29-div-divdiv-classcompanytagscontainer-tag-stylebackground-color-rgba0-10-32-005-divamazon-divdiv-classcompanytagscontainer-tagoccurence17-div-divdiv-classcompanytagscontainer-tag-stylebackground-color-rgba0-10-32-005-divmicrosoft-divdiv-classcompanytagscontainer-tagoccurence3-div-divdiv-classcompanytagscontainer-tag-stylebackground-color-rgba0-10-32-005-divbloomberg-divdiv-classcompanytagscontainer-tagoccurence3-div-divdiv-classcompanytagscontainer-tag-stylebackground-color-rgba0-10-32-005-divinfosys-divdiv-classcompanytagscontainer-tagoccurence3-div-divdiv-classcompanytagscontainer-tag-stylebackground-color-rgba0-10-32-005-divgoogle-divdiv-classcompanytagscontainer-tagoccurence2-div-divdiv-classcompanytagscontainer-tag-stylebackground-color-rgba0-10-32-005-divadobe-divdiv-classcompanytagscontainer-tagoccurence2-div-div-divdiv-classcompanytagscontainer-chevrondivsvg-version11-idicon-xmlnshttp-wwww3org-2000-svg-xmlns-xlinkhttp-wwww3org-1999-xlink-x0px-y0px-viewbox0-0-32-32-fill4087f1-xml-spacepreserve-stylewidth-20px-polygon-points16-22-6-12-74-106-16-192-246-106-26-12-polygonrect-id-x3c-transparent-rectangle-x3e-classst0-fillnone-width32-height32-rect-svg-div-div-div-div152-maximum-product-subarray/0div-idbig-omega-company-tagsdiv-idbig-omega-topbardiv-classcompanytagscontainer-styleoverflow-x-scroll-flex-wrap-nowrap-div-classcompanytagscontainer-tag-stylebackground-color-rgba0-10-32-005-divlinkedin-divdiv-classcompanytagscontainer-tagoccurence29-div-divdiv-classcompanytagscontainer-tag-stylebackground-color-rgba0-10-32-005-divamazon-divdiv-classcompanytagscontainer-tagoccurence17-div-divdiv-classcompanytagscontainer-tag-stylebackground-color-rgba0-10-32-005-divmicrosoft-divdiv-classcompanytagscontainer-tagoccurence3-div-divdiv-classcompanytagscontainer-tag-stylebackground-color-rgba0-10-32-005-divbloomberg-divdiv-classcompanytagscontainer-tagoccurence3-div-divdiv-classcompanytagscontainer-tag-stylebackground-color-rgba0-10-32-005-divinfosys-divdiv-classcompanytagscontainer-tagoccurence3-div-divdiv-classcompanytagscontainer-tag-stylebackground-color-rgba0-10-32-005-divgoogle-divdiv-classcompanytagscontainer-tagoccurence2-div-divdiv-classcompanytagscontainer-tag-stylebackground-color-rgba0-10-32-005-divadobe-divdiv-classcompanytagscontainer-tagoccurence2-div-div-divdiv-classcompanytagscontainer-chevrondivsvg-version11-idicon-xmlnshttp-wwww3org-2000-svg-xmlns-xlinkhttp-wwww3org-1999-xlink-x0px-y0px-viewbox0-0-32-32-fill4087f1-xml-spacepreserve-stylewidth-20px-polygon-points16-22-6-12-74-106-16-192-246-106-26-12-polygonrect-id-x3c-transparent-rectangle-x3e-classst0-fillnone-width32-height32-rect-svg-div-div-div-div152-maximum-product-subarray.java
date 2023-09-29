class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int min = nums[0];
        int max = nums[0];
        
        for(int i=1;i<n;i++){
            int temp = Math.max(nums[i],Math.max(nums[i]*min,nums[i]*max));
            min = Math.min(nums[i],Math.min(nums[i]*min,nums[i]*max));
            res = Math.max(res,temp);
            max = temp;
        }
    
        return res;
    }
    
    
//     public int maxProduct(int[] nums) {
//         int n = nums.length;
//         int currProd = 1;
//         int leftMax = Integer.MIN_VALUE;
        
//         for(int num:nums){
//             if(currProd==0) currProd=1;
//             currProd *= num;
//             leftMax = Math.max(leftMax,Math.max(currProd,num));
//         }
//         currProd = 1;
//         int rightMax = Integer.MIN_VALUE;
        
//         for(int i=n-1;i>=0;i--){
//             int num = nums[i];
//             if(currProd==0) currProd=1;
//             currProd *= num;
//             rightMax = Math.max(rightMax,Math.max(currProd,num));
//         }
        
//         return Math.max(leftMax,rightMax);
//     }
}