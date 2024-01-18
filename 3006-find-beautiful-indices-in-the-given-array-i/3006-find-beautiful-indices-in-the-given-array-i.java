class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        int n = s.length();
        int n1 = a.length();
        int n2 = b.length();
        
        List<Integer> res = new ArrayList<>();
        
        List<Integer> aMatch = new ArrayList<>();
        List<Integer> bMatch = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            if(i<=n-n1 && s.substring(i,i+n1).equals(a)) aMatch.add(i);
            if(i<=n-n2 && s.substring(i,i+n2).equals(b)) bMatch.add(i);
            
        }
        
        for(int l: aMatch){
            for(int r: bMatch){
                if(Math.abs(l-r) <= k){
                    res.add(l);
                    break;
                }
            }
        }
        
        return res;
    }
}