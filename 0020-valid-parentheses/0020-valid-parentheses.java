class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(stk.size()==0 && (ch==')' || ch==']' || ch=='}')) return false;
            if(ch=='(' || ch=='[' || ch=='{') stk.push(ch);
            else if((ch==')' && stk.peek()=='(') || (ch==']' && stk.peek()=='[') || (ch=='}' && stk.peek()=='{')){
                stk.pop();
            }
            else return false;
        }
        if(stk.size()==0) return true;
        return false; 
    }
}