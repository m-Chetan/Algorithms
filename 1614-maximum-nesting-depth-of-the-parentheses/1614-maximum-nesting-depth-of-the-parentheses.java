class Solution {
    public int maxDepth(String s) {
        int res = 0;
        int open = 0;
        
        for(char ch: s.toCharArray()){
            if(ch=='('){
                open++;
                res = Math.max(res,open);
            }
            if(ch==')') open--;
        }
        
        
        return res;
    }
}