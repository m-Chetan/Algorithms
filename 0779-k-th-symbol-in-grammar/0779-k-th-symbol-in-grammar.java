class Solution {
    public int kthGrammar(int n, int k) {
        if(n==1) return 0;
        if(n==2){
            if(k==1) return 0;
            return 1;
        }
        
        int len = 1<<(n-1);
        
        if(k>len/2){
            int res = kthGrammar(n-1,k-(len/2));
            if(res==0) return 1;
            return 0;
        }
        return kthGrammar(n-1,k);
    }
}