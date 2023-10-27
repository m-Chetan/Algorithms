class Solution {
    //O(N) Manacher's algorithm
    
    public String longestPalindrome(String s){
        int n = s.length();
        
        StringBuilder sb = new StringBuilder("^#");
        
        for(char c: s.toCharArray()) sb.append(c+"#");
        sb.append("$");
        
        int C=0, R=0;
        int[] lps = new int[sb.length()];
        
        for(int i=1;i<sb.length()-1;i++){
            lps[i] = (R>i) ? Math.min(lps[2*C-i], R-i) : 0;
            
            while(sb.charAt(i+lps[i]+1) == sb.charAt(i-lps[i]-1)){
                lps[i]++;
            }
            
            if(i+lps[i] > R){
                R = i+lps[i];
                C=i;
            }
        }
        
        String res = "";
        int max = Integer.MIN_VALUE;
        for(int i=1;i<lps.length-1;i++){
            if(lps[i]>max){
                max = lps[i];
                res = s.substring( (i-lps[i])/2, (i+lps[i])/2 );
            }
        }
        
        
        return res;
        
    }
    
    
    
    //O(N^2)
//     public String longestPalindrome(String s) {
//         int n = s.length();
//         String res = "";
//         int longest = 0;
        
//         boolean[][] dp = new boolean[n][n];
        
//         for(int i=0;i<n;i++) Arrays.fill(dp[i],true);
        
//         for(int i=n-1;i>=0;i--){
//             for(int j=i;j<n;j++){
//                 if(i==j){
//                     if(j-i+1 > longest)
//                         res = s.substring(i,j+1);
//                     continue;
//                 }
//                 char ch1 = s.charAt(i);
//                 char ch2 = s.charAt(j);
                
//                 if(ch1 == ch2 && dp[i+1][j-1]==true){
//                     int len = (j-i+1);
//                     if(len > longest){
//                         longest = len;
//                         res = s.substring(i,j+1);
//                     }
//                 }
//                 else dp[i][j] = false;
                
                
//             }
//         }
        
//         return res;
//     }
}