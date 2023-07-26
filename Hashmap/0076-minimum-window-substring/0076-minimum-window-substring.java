class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        
        HashMap<Character,Integer> hmt = new HashMap<>();
        HashMap<Character,Integer> hms = new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            hmt.put(ch,hmt.getOrDefault(ch,0)+1);
        } 
        
        String ans = "";
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int count = 0;
        
        for(int end=0;end<s.length();end++){
            char ch = s.charAt(end);
            if(hmt.containsKey(ch)){
                hms.put(ch,hms.getOrDefault(ch,0)+1);
                if(hms.get(ch) <= hmt.get(ch))
                    count++;
            }
            
            while(count == t.length()){
                if((end-start+1) < minLen){
                    ans = s.substring(start,end+1);
                    minLen = end-start+1;
                }
                char startCh = s.charAt(start);
                if(hms.containsKey(startCh)){
                    if(hms.get(startCh) <= hmt.get(startCh)) count--;
                    hms.put(startCh,hms.get(startCh)-1);    
                }
                    
                start++;      
            }
            
        }
        
        return ans;
    }
}