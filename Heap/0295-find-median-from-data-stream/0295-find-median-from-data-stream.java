class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(maxHeap.size() == 0){
            maxHeap.add(num);
        }
        else if(num <= maxHeap.peek()){
            maxHeap.add(num);
        }
        else{
            minHeap.add(num);
        }
        
        if(Math.abs(maxHeap.size()-minHeap.size()) > 1){
            if(maxHeap.size()>minHeap.size()){
                minHeap.add(maxHeap.remove());
            }
            else{
                maxHeap.add(minHeap.remove());
            }
        }
        
    }
    
    public double findMedian() {
        if(minHeap.size() == 0 && maxHeap.size() == 0) return 0.0;
        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }
        else if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek() * 1.0;
        }
        else{
            return minHeap.peek() * 1.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */