class Solution {
    public int[] countBits(int n) {
        int ans[]=new int[n + 1];
        if (n == 0)
            return new int[]{0};
        if (n == 1)
            return new int[]{0,1};
        ans[0] = 0;
        ans[1] = 1;
        for (int i = 2; i <= n; i++)
            ans[i] = (i%2 !=0) ? ans[i / 2] + 1 : ans[i / 2];
    
        return ans;
    }
}