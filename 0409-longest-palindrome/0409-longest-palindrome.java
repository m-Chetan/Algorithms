class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(char ch:s.toCharArray()) map.put(ch,map.getOrDefault(ch,0)+1);
        
        int res = 0;
        boolean odd = false;
        for(Character key:map.keySet()){
            if(map.get(key)%2==0) res += map.get(key);
            else{ 
                res += map.get(key)-1;
                odd = true;
            }
        }
        
        return odd==true ? res+1 : res;
    }
}