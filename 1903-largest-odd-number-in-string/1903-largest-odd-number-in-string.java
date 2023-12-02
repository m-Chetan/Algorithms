class Solution {
    public String largestOddNumber(String num) {
        StringBuilder sb = new StringBuilder(num);
        
        int i = num.length()-1;
        while(i>=0 && (sb.charAt(i)-'0')%2 == 0 ){
            sb.delete(i,i+1);
            i--;
        }
        
        return sb.toString();
    }
}