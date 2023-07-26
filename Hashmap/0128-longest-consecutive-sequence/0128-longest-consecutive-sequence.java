class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> map = new HashMap<>();
        
        for(int ele:nums){
            map.put(ele,true);
        }
        
        for(int key : map.keySet()){
            if(map.containsKey(key-1)){
                map.put(key,false);
            }
        }

        int ans = 0;
        for(int key:map.keySet()){
            int count = 0;
            if(map.get(key) == true ){
                int nextEle = key; 
                while(map.containsKey(nextEle)){
                    nextEle++;
                    count++;
                }
                
            }
            ans = Math.max(ans,count);
        }
        
        return ans;
    }
}