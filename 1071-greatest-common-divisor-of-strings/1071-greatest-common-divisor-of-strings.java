class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String s1 = str1+str2;
        String s2 = str2+str1;
        
        if(!s1.equals(s2)) return "";
        
        int m=str1.length(), n=str2.length();
        int gcd = gcd(m,n);
        
        return str1.substring(0,gcd);
        
    }
    
    private int gcd(int a, int b){
        while (a > 0 && b > 0) {
            if (a > b) {
                a = a % b;
            }
            else {
                b = b % a;
            }
        }
        if (a == 0) return b;
            
        return a;    
    }
}