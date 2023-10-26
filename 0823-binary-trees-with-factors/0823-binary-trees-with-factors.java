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

// public class Solution {
//     private static final int MOD = 1000000007;

//     public int numFactoredBinaryTrees(int[] arr) {
//         Arrays.sort(arr);
      
//         Map<Integer, Integer> dp = new HashMap<>();
//         for (int x : arr) dp.put(x, 1);
        
//         int result = 0;
        
//         for (int i : arr) {
//             for (int j : arr) {
//                 if (j > Math.sqrt(i)) break;
//                 if (i % j == 0 && dp.containsKey(i / j)) {
//                     long temp = (long) dp.get(j) * dp.get(i / j);
//                     dp.put(i, (int) ((dp.get(i) + (i / j == j ? temp : temp * 2)) % MOD));
//                 }
//             }
//             result = (result + dp.get(i)) % MOD;
//         }
        
  
//         return result;
//     }
// }

