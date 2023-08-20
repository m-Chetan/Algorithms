class SmallestInfiniteSet {
    PriorityQueue<Integer> pq;
    int n;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        n = 1;
    }
    
    public int popSmallest() {
        if(pq.size()>0){
            return pq.remove();
        }
        n++;
        return n-1;
    }
    
    public void addBack(int num) {
        if(num<n && !pq.contains(num)) pq.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */