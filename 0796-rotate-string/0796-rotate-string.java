class Solution {
    public boolean rotateString(String s, String goal) {
        String str = s + s;
        int n = goal.length();
        int m = s.length();
        
        if(m!=n) return false;
        
        for(int i=0;i<str.length()-n;i++){
            if(str.substring(i,i+n).equals(goal)) return true;
        }
        
        return false;
    }
}