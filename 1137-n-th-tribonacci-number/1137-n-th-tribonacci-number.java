class Solution {
    public int tribonacci(int n) {
        if(n==0) return 0;
        if(n<=2) return 1;
        
        n -= 2;
        int t0 = 0, t1 = 1, t2 = 1, sum = 0; 
        while(n>0){
            sum = t0+t1+t2;
            t0=t1;
            t1=t2;
            t2=sum;
            n--;
        }
        
        return sum;
    }
}