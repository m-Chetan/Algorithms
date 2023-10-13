class Solution {
    public String multiply(String num1, String num2) {
 
        int m = num1.length(), n = num2.length();
        
        if(m==1 && Integer.parseInt(num1) == 0) return "0";
        if(n==1 && Integer.parseInt(num2) == 0) return "0";
        
        
        int[] res = new int[n+m];
        int last = res.length-1;
        
        for(int i=n-1;i>=0;i--){
            int k = last;
            int d2 = num2.charAt(i)-'0';
            int carry = 0;
            for(int j=m-1;j>=0;j--){
                int d1 = num1.charAt(j)-'0';
                int prod = d1 * d2;
                int sum = res[k] + prod + carry;
                res[k] = sum%10;
                carry = sum/10;
                k--;
            }
            if(carry>0) res[k] += carry;
            last--;
        }
        
        int i=0;
        while(res[i] == 0) i++;
        
        StringBuilder sb = new StringBuilder("");
        
        while(i<res.length){
            sb.append(res[i]);
            i++;
        }
        
        return sb.toString();
    }
}