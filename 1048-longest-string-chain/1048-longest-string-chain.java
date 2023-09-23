class Solution {
    /*
        1) Sort the array according to increasing length
        2) Create HashMap for storing word and its longest chain <String,Integer> 
        3) for each word itearate through each character    
        4) Now skip ith character and check remaining substring is present in hashmap
            For e.g word = abcd
                    for i=0, str = bcd check bcd is in hashmap if presend add it to chain 
                        i=1, str = acd
        5) return max length
        
        Time Complexity: O(nlog(n) + nll)
                         O(nlog(n)) for sorting
                         O(nll): n for each loop, l for inner loop and l for string concatenation.
        
        Space Complexity:O(ns)
                         O(n) for both sorting and storing in dictionary.
                         O(ns): s for creating space for remaining str, n times.
    */
    
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b) -> a.length()-b.length());
        
        HashMap<String,Integer> dp = new HashMap<>();
        int ans = 0;
        
        for(String word: words){
            int max = 0;
            for(int i=0;i<word.length();i++){
                String str = word.substring(0,i) + word.substring(i+1);
                max = Math.max(max,dp.getOrDefault(str,0)+1);
            }
            dp.put(word,max);
            ans = Math.max(ans,max);
        }
        
        return ans;
    }
    
    
    //Time -> O(NlogN + N^2 * word.len) space -> O(N)
//     public int longestStrChain(String[] words) {
//         Arrays.sort(words, (a,b) -> a.length()-b.length());
//         int[] dp = new int[words.length];
//         Arrays.fill(dp,1);
//         int ans = 1;
        
//         for(int i=words.length-2;i>=0;i--){
//             int max = 0;
//             for(int j=i+1; j<words.length; j++){
//                 if(isPossible(words[i],words[j])){
//                     max = Math.max(max,dp[j]);
//                 }
//             }
            
//             dp[i] = max+1;
//             ans = Math.max(ans,dp[i]);
//         }
 
//         return ans;
//     }
    
//     private boolean isPossible(String word1, String word2){
//         if(word1.equals(word2) || word2.length()-word1.length() > 1) return false;
//         if(word1.length() == word2.length()) return word1.equals(word2); 
        
//         int i=0, j=0;
//         int count = 0;
//         while(i<word1.length() && j<word2.length()){
//             if(word1.charAt(i) == word2.charAt(j)){
//                 i++; j++;
//             }
//             else{
//                 count++;
//                 j++;
//             }
//         }
//         if(j==word2.length()-1) count++;
        
//         return count==1;
        
//     }
}