class Solution {
    public int minAddToMakeValid(String s) {
        int countOpen = 0;
        int countClose = 0;
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(ch == '(') countOpen++;
            else if(ch == ')' && countOpen == 0) countClose++;
            else countOpen--;
        }
        
        return countOpen+countClose;
    }
}