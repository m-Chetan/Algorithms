class Solution {
    public String decodeAtIndex(String s, int k) {
        long len = 0;
        int i =0;
        while(len<k){
            if(Character.isDigit(s.charAt(i))){
                len *= s.charAt(i)-'0';
            }
            else len++;
            i++;
        }
        
        for(int j=i-1;j>=0;j--){
            if(Character.isDigit(s.charAt(j))){
                len /= s.charAt(j)-'0';
                k %= len;
            }
            else{
                if(k==0 || len==k){
                    return s.charAt(j)+"";
                }
                len--;
            }
            
        }
        
        return "";
    }
}