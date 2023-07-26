class RandomizedSet {
    HashMap<Integer,Integer> idxMap;
    List<Integer> nums;
    Random random;      //to generate random number [i,j)
    
    public RandomizedSet() {
        idxMap = new HashMap<>();
        nums = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(idxMap.containsKey(val)) return false;
        
        int index = nums.size();
        
        idxMap.put(val,index);
        nums.add(val);
        
        return true;
    }
    
    public boolean remove(int val) {
        if(!idxMap.containsKey(val)) return false;
        
        int index = idxMap.get(val);
        idxMap.remove(val);
        
        int lastIdx = nums.size()-1;
        
        if(index != lastIdx){
            nums.set(index,nums.get(lastIdx));
            idxMap.put(nums.get(index),index);
        }
        nums.remove(lastIdx);

        return true;
    }
    
    public int getRandom() {
        int ranIdx = random.nextInt(nums.size());
        return nums.get(ranIdx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */