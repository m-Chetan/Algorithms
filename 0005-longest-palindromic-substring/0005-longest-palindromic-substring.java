class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        int longest = 0;
        
        boolean[][] dp = new boolean[n][n];
        
        for(int i=0;i<n;i++) Arrays.fill(dp[i],true);
        
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(i==j){
                    if(j-i+1 > longest)
                        res = s.substring(i,j+1);
                    continue;
                }
                char ch1 = s.charAt(i);
                char ch2 = s.charAt(j);
                
                if(ch1 == ch2 && dp[i+1][j-1]==true){
                    int len = (j-i+1);
                    if(len > longest){
                        longest = len;
                        res = s.substring(i,j+1);
                    }
                }
                else dp[i][j] = false;
                
                
            }
        }
        
        return res;
    }
}