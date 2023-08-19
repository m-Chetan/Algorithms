class Solution {
    //f(n) = 2*f(n-1) + f(n-3)
    
    public int numTilings(int n) {
        if(n<=1) return 1;
        int mod = 1000000007;
        int f0=1, f1=1, f2=2;
        
        for(int i=3;i<=n;i++){
            int ways = ((2*f2)%mod + f0)%mod;
            f0 = f1;
            f1 = f2;
            f2 = ways;
        }
        return f2%mod;
    }
}