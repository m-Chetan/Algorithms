class Solution {
    public int largestVariance(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        return Math.max(helper(s),helper(sb.toString()));
    }
    
    private int helper(String s){
        int largestVar=0;
         
        for(char ch1='a';ch1<='z';ch1++){
            for(char ch2='a';ch2<='z';ch2++){
                if(ch1==ch2) continue;
                
                int count1=0, count2=0;
                
                for(char ch: s.toCharArray()){
                    if(ch==ch1) count1++;
                    if(ch==ch2) count2++;
                    
                    if(count1<count2) count1=count2=0;
                    
                    if(count1>0 && count2>0)
                        largestVar = Math.max(largestVar,count1-count2);
                    
                }
                
            }
        }
        
        return largestVar;
    }
}