class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int n = arr.length;
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int num:arr) freq.put(num,freq.getOrDefault(num,0)+1);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int key: freq.keySet()){
            pq.add(freq.get(key));
        }

        while(k>0){
            int top = pq.remove();
            k -= top;
        }
        
        int res = 0;
        if(k<0) res++;
        
        return pq.size()+res;
    }
}