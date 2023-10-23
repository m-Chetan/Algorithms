class Solution {
    public boolean isPowerOfFour(int n) {
        double res = Math.log(n)/Math.log(4);
        return res == (int)res;
    }
}