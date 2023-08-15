class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        StringBuilder sb = new StringBuilder("");
        int i=0, j=0;
        
        while(i<m && j<n){
            char c1 = word1.charAt(i);
            sb.append(c1);
            char c2 = word2.charAt(j);
            sb.append(c2);
            i++; j++;
        }
        if(i<m) sb.append(word1.substring(i));
        
        if(j<n) sb.append(word2.substring(j));
        
        return sb.toString();
    }
}