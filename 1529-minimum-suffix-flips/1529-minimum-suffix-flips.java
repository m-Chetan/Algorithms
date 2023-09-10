class Solution {
    public int minFlips(String target) {
        int n = target.length();
        
        int i=0;
        while(i<n && target.charAt(i)=='0') i++;
        
        if(i==n) return 0;
        
        int res = 0;
        
        while(i<n-1){
            char ch1 = target.charAt(i);
            char ch2 = target.charAt(i+1);
            
            if(ch1 != ch2) res++;
            i++;
        }
        
        return res+1;
    }
}