class MyHashMap {
    LinkedList<Node>[] buckets;
    int size = 0;
    
    public MyHashMap() {
        initBuckets(4);
    }
    
    public void put(int key, int value) {

        int bucketId = getBucket(key);
        
        for(Node node: buckets[bucketId]){
            if(node.key == key){
                node.val = value;
                return;
            }
        }
 
        buckets[bucketId].addLast(new Node(key,value));
        size++;
        
        double lambda = (size*1.0)/buckets.length;
        if(lambda>2){
            rehash();
        }
    }
    
    public int get(int key) {
        int bucketId = getBucket(key);
        for(Node node: buckets[bucketId]){
            if(node.key == key){
                return node.val;
            }
        }
        
        return -1;
    }
    
    public void remove(int key) {
        int bucketId = getBucket(key);
        for(Node node: buckets[bucketId]){
            if(node.key == key){
                buckets[bucketId].remove(node);
                size--;
                return;
            }
        }
        
    }
    
    private int getBucket(int key){
        return Integer.hashCode(key)%buckets.length;
    }
    
    private void rehash(){
        LinkedList<Node>[] oldBucket = buckets;
        
        initBuckets(oldBucket.length*2);
        
        for(int i=0;i<oldBucket.length;i++){
           for(Node node:oldBucket[i]){
               put(node.key,node.val);
           } 
        }
    }
    
    private void initBuckets(int N){
        buckets = new LinkedList[N];
        for(int i=0;i<N;i++){
            buckets[i] = new LinkedList<>();
        }
    }
}

class Node{
    int key;
    int val;
    
    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */