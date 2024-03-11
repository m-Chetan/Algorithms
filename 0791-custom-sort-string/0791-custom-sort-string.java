class Solution {
    public String customSortString(String order, String s) {
    
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        
        String res = "";
        
        for(int i=0;i<order.length();i++){
            char key = order.charAt(i);
            if(map.containsKey(key)){
                for(int j=0;j<map.get(key);j++){
                    res += key;
                }
                map.remove(key);
            }
        }
        
        
        for(char key: map.keySet()){
            for(int j=0;j<map.get(key);j++){
                res += key;
            }
        }
        
        return res;
    }
}