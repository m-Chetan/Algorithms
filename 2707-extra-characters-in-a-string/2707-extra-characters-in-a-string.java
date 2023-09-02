class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        int[] dp = new int[n+1];
        
        for(int i=n-1;i>=0;i--){
            int maxLen = 0;
            for(String word: dictionary){
                int wordLen = word.length();
                 
               // check if the remaining substring is less than or equal to dictonary word
                if(n-i >= wordLen){
                    //check if the remaining substring is equal to dictionary word
                    
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