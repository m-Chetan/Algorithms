class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        String res = "";
        
        Arrays.sort(strs);
        
        for(int i=0;i<strs[0].length();i++){
            if(strs[0].charAt(i) != strs[strs.length-1].charAt(i)){
                break;
            }
            
            res += strs[0].charAt(i);
        }
        
        return res;
    }
}