class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        
        helper(0,s,res,new ArrayList<>());
        
        return res;
    }
    
    private void helper(int idx,String s,List<List<String>> res, List<String> list){
        if(idx==s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=idx;i<s.length();i++){
            String substring = s.substring(idx,i+1);
            if(isPalindrome(substring)){
                list.add(substring);
                helper(i+1,s,res,list);
                list.remove(list.size()-1);
            }
        }
        
    }
    
    private boolean isPalindrome(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        }
        return true;
    }
    
}