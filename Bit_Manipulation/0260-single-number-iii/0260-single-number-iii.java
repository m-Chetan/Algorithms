class Solution {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for(int num: nums) xor ^= num;
        
        int msb = xor & -xor;
        int num1 = xor;
        
        for(int num:nums){
            if((num & msb) !=0 ) xor ^= num; 
        }

        num1 ^= xor;
        
        return new int[]{num1,xor};
    }
}