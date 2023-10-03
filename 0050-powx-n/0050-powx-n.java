class Solution {
    public double myPow(double x, int n) {
        if(x==0) return 0.0;
        if(n==0) return 1.0;
        
        if(n<0) return 1/power(x,n);
        
        return power(x,n);
    }
    
    private double power(double x, int n){
        if(n==1) return x;
        if(n==0) return 1;
        
        double nby2 = power(x,n/2);

        if(n%2==0) return nby2 * nby2;
        
        return x*nby2*nby2;        
    }
}