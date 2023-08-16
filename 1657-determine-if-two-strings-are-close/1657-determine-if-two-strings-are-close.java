class Solution {
    public boolean closeStrings(String word1, String word2) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        
        for(char ch:word1.toCharArray()) map1.put(ch,map1.getOrDefault(ch,0)+1);
        for(char ch:word2.toCharArray()) {
            if(!map1.containsKey(ch)) return false;
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        if(map1.size() != map2.size()) return false;
        
        HashMap<Integer,Integer> freq1 = new HashMap<>();
        HashMap<Integer,Integer> freq2 = new HashMap<>();
        
        for(char ch:map1.keySet()){
            int freq = map1.get(ch);
            freq1.put(freq,freq1.getOrDefault(freq,0)+1);
        }
        
        for(char ch:map2.keySet()){
            int freq = map2.get(ch);
            if(!freq1.containsKey(freq)) return false;
        
            freq2.put(freq,freq2.getOrDefault(freq,0)+1);
            if(freq2.get(freq) > freq1.get(freq)) return false;
        }
            
        return true;
    }
}