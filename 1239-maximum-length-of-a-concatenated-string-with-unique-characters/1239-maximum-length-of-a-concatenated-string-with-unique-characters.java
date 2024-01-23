class Solution {
    public int maxLength(List<String> arr) {
        return helper(0,"",arr);
    }
    
    private int helper(int idx, String res, List<String> arr){
        if(idx==arr.size()){
            if(isUnique(res)) return res.length();
            return 0;
        }
        
        int yes = helper(idx+1,res+arr.get(idx),arr);
        int no = helper(idx+1,res,arr);
        
        return Math.max(yes,no);
    }
    
    private Boolean isUnique(String str){
        Set<Character> set = new HashSet<>();
        
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(set.contains(ch)) return false;
            set.add(ch);
        }
        
        return true;
    }
}