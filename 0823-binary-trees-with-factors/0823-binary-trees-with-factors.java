class Solution {
    
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        int MOD = 1000000007;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int e: arr) map.put(e,1);
        
        int res = 0;
        
        for(int i: arr){
            for(int j: arr){
                
                if (j > Math.sqrt(i)) break;
                
                if( i%j == 0 && map.containsKey(i/j)){

                    long combination = (long) map.get(j) * map.get(i/j);
                    
                    map.put(i, (int)( (map.get(i) + (i/j == j ?  combination : combination*2) )%MOD) );
                }
            }
            res = (res + map.get(i) )%MOD; 
        }
        
        return res;
        
    }
}
