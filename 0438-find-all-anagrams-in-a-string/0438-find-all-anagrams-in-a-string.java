class Solution {
    public List<Integer> findAnagrams(String s2, String s1) {
        List<Integer> ans = new ArrayList<>();
        
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        
        HashMap<Character,Integer> map2 = new HashMap<>();
        int start = 0;
        for(int end=0; end<s2.length();end++){
            char ch = s2.charAt(end);
            map2.put(ch, map2.getOrDefault(ch,0)+1);
            
            while(start<=end && (!map.containsKey(ch) ||  map2.get(ch) > map.get(ch))){
                char startCh = s2.charAt(start);
                map2.put(startCh,map2.get(startCh)-1);
                if(map2.get(startCh) == 0) map2.remove(startCh);
                start++;
            }
        
            if(end-start+1 == s1.length()){
                ans.add(start);
            }
        }
        
        return ans;
    }
}