class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int num:arr){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int key: freq.keySet()){
            int val = freq.get(key);
            if(set.contains(val)) return false;
            set.add(val);
        }
        
        return true;
    }
}