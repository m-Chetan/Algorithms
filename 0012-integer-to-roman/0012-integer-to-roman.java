class Solution {
 
    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder("");
        String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"}; 
        int[] val = {1000,900,500,400,100,90,50,40,10,9,5,4,1};       
        
        for(int i=0;i<val.length;i++){
            while(num >= val[i]){
                num -= val[i];
                roman.append(symbol[i]);
            }
        }
        
        return roman.toString();
    }
}