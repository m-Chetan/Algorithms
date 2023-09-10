class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        PriorityQueue<Integer>[] bucket = new PriorityQueue[32];
        
        for(int num: arr){
            int bits = Integer.bitCount(num);
            if(bucket[bits]==null){
                bucket[bits] = new PriorityQueue<>();    
            }
            bucket[bits].add(num);
        }
        
        int[] res = new int[n];
        int idx = 0;
        for(int i=0;i<32;i++){
            if(bucket[i] != null){
                while(bucket[i].size()>0){
                    res[idx++] = bucket[i].remove();
                }
            }
        }
        
        return res;
        
    }
}