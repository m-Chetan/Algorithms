class Solution {
    int MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long res = (power(5,n/2)%MOD * power(4,n/2)%MOD)%MOD;
        
        if(n%2!=0) res = (res*5)%MOD;
        
        return (int)res;
    }
    
    private long power(int x, long n){
        if(n==1) return x;
        if(n==0) return 1;
        
        long nby2 = power(x,n/2)%MOD;

        if(n%2==0) return (nby2 * nby2)%MOD;
        
        return (x*nby2*nby2)%MOD;        
    }
}