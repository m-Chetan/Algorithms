class Solution {
    private static String[] keypads = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        return getCombinations(0,digits);
    }
    
    private List<String> getCombinations(int idx, String digits){
        if(idx == digits.length()){
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        
        List<String> letters = getCombinations(idx+1,digits);
        
        List<String> res = new ArrayList<>();
        
        String key = keypads[digits.charAt(idx) - '0'];
        
        for(int i=0;i<key.length();i++){
            for(String str: letters){
                res.add(key.charAt(i) +str);
            }
        }
        
        return res;
    }
}