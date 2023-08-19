class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        
        dfs(0,visited,rooms);
        
        for(boolean vis: visited) if(!vis) return false;
        return true;
    }
    
    private void dfs(int src,boolean[] visited, List<List<Integer>> rooms){
        visited[src] = true;
        for(int nbr:rooms.get(src)){
            if(visited[nbr]==false)
                dfs(nbr,visited,rooms);
        }
    }
}