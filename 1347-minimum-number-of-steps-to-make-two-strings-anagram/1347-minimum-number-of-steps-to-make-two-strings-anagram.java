class Solution {
    public int minSteps(String s, String t) {
        int[] freq = new int[26];
        
        for(char ch: s.toCharArray()){
            freq[ch-'a']++;
        }
        
        int res = s.length();
        
        for(char ch: t.toCharArray()){
            if(freq[ch-'a'] != 0){
                freq[ch-'a']--;
                res--;
            }
        }
        
        return res;
    }
    
}