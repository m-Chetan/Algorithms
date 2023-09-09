class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        int n = time.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int num: time){
            int x = num%60;
            int t = 60 - x;
     
            if(map.containsKey(t)) res += map.get(t);
            
            if(x==0) map.put(60,map.getOrDefault(60,0)+1);
            else map.put(x,map.getOrDefault(x,0)+1);
        }
        
        return res;
    }
}