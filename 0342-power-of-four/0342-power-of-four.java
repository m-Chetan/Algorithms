class Solution {
    public boolean isPowerOfFour(int num) {
        //num & (num-1) means number is power of 2 and  0x55555555 this represents number with set bit '1' at odd positions
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0x55555555) == num);
    }
}