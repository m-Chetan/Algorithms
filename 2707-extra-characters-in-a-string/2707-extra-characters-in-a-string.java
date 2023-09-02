class Solution {
    public int minExtraChar(String s, String[] dict) {
        int n = s.length();
        int m = dict.length;
        int[] dp = new int[n+1];
        
        for(int i=n-1;i>=0;i--){
            int maxLen = 0;
            for(String word: dict){
                int wordLen = word.length();
                    
                if(n-i >= wordLen){
                    if(s.substring(i,i+wordLen).equals(word)){
                        maxLen = Math.max(maxLen,wordLen+dp[i+wordLen]);
                    }
                }
            }
            
            dp[i] = Math.max(dp[i+1],maxLen);
        }
        
        return n-dp[0];
    }
}