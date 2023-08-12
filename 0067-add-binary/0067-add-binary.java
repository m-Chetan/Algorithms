class Solution {
    public String addBinary(String a, String b) {
        int n = a.length(), m = b.length();
        if(n>m) return addBinary(b,a);
        
        String res = "";
        
        int i=n-1, j=m-1;
        int carry = 0;
        while(i>=0 && j>=0){
            int x = a.charAt(i)-'0';
            int y = b.charAt(j)-'0';
            
            int sum = x + y + carry;
            res = sum%2 + res;
            carry = sum/2;
            i--;
            j--;
        }
        
        while(j>=0){
            int sum = (b.charAt(j)-'0') + carry;
            res = sum%2 + res;
            carry = sum/2;
            j--;
        }
        
        if(carry == 1) res = carry + res;
        
        return res;
    }
}