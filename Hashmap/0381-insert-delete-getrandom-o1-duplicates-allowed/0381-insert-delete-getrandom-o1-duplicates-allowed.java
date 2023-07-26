class RandomizedCollection {
    HashMap<Integer,HashSet<Integer>> idxMap;
    List<Integer> nums;
    Random random;
    
    public RandomizedCollection() {
        idxMap = new HashMap<>();
        nums = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        boolean isPresent = false;
        
        HashSet<Integer> idxSet;
        
        if(!idxMap.containsKey(val)){
            idxSet = new HashSet<>();
            isPresent = true;
        }
        else idxSet = idxMap.get(val);
        
        int index = nums.size();
        
        idxSet.add(index);
        nums.add(val);
        idxMap.put(val,idxSet);
        
        return isPresent;
    }
    
    public boolean remove(int val) {
        if(!idxMap.containsKey(val)) return false;
        
        int index = -1;
        
        for(int idx: idxMap.get(val)){
            index = idx;
            break;
        }
        
        idxMap.get(val).remove(index);
        
        int lastIdx = nums.size()-1;
        int lastVal = nums.get(lastIdx);
        nums.remove(lastIdx);
        
        if(lastIdx != index){
            nums.set(index,lastVal);    
            HashSet<Integer> idxSet = idxMap.get(lastVal);
            idxSet.add(index);
            idxSet.remove(lastIdx);
        }
        
        if(idxMap.get(val).size() == 0) idxMap.remove(val);
        
        return true;
    }
    
    public int getRandom() {
        int ranIdx = random.nextInt(nums.size());
        return nums.get(ranIdx);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */