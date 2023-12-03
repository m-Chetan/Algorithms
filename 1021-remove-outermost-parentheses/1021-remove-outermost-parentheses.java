class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        int countOpen = 0;
        String res = "";
        
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '('){
                countOpen++;
                if(countOpen>1) res += '(';
            }
            else{
                countOpen--;
                if(countOpen!=0) res += ')';
            }
        }
        
        return res;
    }
}