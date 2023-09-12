/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        Set<Node> visited = new HashSet<>();
        HashMap<Node,Node> map = new HashMap<>();
        dfs(node,visited,map);
        
        return map.get(node);
    }
    
    private void dfs(Node node,Set<Node> visited,HashMap<Node,Node> map){
        Node newNode;
        
        if(map.containsKey(node)) newNode = map.get(node);
        else{
            newNode = new Node(node.val);
            map.put(node,newNode);
        }       
        visited.add(node);
        
        for(Node nbr: node.neighbors){
            if(!visited.contains(nbr)){
                Node nbrNode = new Node(nbr.val);
                map.put(nbr,nbrNode);
                newNode.neighbors.add(nbrNode);
                dfs(nbr,visited,map);
            }
            else newNode.neighbors.add(map.get(nbr));
        }
            
    }
}