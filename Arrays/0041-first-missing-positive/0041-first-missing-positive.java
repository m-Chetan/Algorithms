class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        //Since we want smallest positive number it will come between 1 to n
        //So eliminate negative number to n+1
        for(int i=0;i<n;i++)
            if(nums[i]<=0) nums[i] = n+1;
        
        //Now if nums[i] >0 && <=n then make its correct position in array to negative means its visited
        
        for(int i=0;i<n;i++){
            if(Math.abs(nums[i]) <= n){
                nums[Math.abs(nums[i])-1] = -Math.abs(nums[Math.abs(nums[i])-1]);
            }
        }
               
        for(int i=0;i<n;i++)
            if(nums[i] > 0) return i+1;
               
        return n+1;
    }
}