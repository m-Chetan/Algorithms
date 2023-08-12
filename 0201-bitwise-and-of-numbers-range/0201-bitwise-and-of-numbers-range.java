class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int count = 0;
        
        while(Math.abs(left-right) > 1){
            left = left>>1;
            right = right>>1;
            count++;
        }
        
        return (left&right)<<count;
    }
}