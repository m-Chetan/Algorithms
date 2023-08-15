class Solution {
    public String simplifyPath(String path) {
        String[] dir = path.split("/");
        Stack<String> stk = new Stack<>();
        
        for(String str: dir){
            if(stk.size()>0 && str.equals("..")) stk.pop();
            
            else if(str.length()!=0 && !str.equals(".") && !str.equals("..")) stk.push(str);    
        }
        
        if(stk.size() == 0) return "/";
        
        String res = "";

        while(stk.size()>0){
            res = "/"+stk.pop() + res;
        }
        
        return res;
        
    }
}