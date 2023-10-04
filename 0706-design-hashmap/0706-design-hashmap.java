class MyHashMap {
    LinkedList<Node>[] buckets;
    int capacity;
    
    public MyHashMap() {
        capacity = 4;
        buckets = new LinkedList[4];
    }
    
    public void put(int key, int value) {

        int bucketId = getBucket(key);
        if(buckets[bucketId] == null) buckets[bucketId] = new LinkedList<>();
        
        for(Node node: buckets[bucketId]){
            if(node.key == key){
                node.val = value;
                return;
            }
        }
 
        buckets[bucketId].addLast(new Node(key,value));
    }
    
    public int get(int key) {
        int bucketId = getBucket(key);
        if(buckets[bucketId] == null) return -1;
        
        for(Node node: buckets[bucketId]){
            if(node.key == key){
                return node.val;
            }
        }
        
        return -1;
    }
    
    public void remove(int key) {
        int bucketId = getBucket(key);
        if(buckets[bucketId] == null) return;
        for(Node node: buckets[bucketId]){
            if(node.key == key){
                buckets[bucketId].remove(node);
                return;
            }
        }
        
    }
    
    private int getBucket(int key){
        return this.hashCode()%capacity;
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