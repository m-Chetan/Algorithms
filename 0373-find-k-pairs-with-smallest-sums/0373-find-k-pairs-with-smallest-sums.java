class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.sum-b.sum);
        Set<Node> set = new HashSet<>();
        
        pq.add(new Node(nums1[0]+nums2[0],0,0));
        
        List<List<Integer>> res = new ArrayList<>();
        
        while(pq.size()>0){
            Node node = pq.remove();
            if(set.contains(node)) continue;
            set.add(node);
            res.add(new ArrayList<>(List.of(nums1[node.i],nums2[node.j])));
            k--;
            if(k==0) break;
            
            if(node.i+1 < m){
                pq.add(new Node(nums1[node.i+1]+nums2[node.j],node.i+1,node.j));
            }
            
            if(node.j+1 < n){
                pq.add(new Node(nums1[node.i]+nums2[node.j+1],node.i,node.j+1));
            }
            
        }
        
        return res;
    }
}

class Node{
    int sum;
    int i,j;
    public Node(int sum, int i, int j){
        this.sum = sum;
        this.i = i;
        this.j = j;
    }
    
    @Override
    public boolean equals(Object o){
        Node obj = (Node)o;
        return (i == obj.i && j == obj.j);
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(i,j);
    }
    
    
}