class RecentCounter {
    Queue<Integer> q;
    int counter;
    public RecentCounter() {
        q = new LinkedList<>();
        counter = 0;
    }
    
    public int ping(int t) {
        int start = t-3000;
        
        while(q.size()>0 && q.peek() < start){
            q.remove();
            counter--;
        }
        
        q.add(t);
        counter++;
        
        return counter;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */