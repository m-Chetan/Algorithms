class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder("");
            for(int j=0;j<n;j++){
                sb.append(grid[i][j]);
                sb.append("@");
            }
            String str = sb.toString();
            map.put(str,map.getOrDefault(str,0)+1);
        }
        
        int res = 0;
        
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder("");
            for(int j=0;j<n;j++){
                sb.append(grid[j][i]);
                sb.append("@");
            }
            String str = sb.toString();
            if(map.containsKey(str)) res += map.get(str);
        }
        return res;
    }
}