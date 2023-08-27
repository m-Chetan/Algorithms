class Solution {
    public boolean canCross(int[] stones) {
        if(stones[1]!=1) return false;
        int n = stones.length;
        
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        int target = stones[n-1];
        
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        map.put(1,set);
        
        for(int i=1;i<n;i++){
            if(map.containsKey(stones[i]) == false) continue;
            if(map.containsKey(target)) return true;
            for(int lastJump: map.get(stones[i])){
                for(int jump=lastJump-1; jump<=lastJump+1; jump++){
                    if(jump!=0){
                        int nextJump = stones[i]+jump;
                        if(nextJump==target) return true;
                        set = map.getOrDefault(nextJump,new HashSet<>());
                        set.add(jump);
                        map.put(nextJump,set);
                    }
                }
            }
        }
            
    
        return false;
    }
}