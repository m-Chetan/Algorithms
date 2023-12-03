class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        int[] freq = new int[256];
        
        for(char c:s.toCharArray()) freq[c]++;
        
        ArrayList<Integer>[] freqCount = new ArrayList[n+1];
        for(int i=0;i<=n;i++) freqCount[i] = new ArrayList<>();
        
        for(int i=0;i<256;i++){
            if(freq[i] != 0){
                freqCount[freq[i]].add(i);
            }
        } 
   
        
        StringBuilder res = new StringBuilder();
        
        for(int i=n;i>=0;i--){
            if(freqCount[i].size() != 0){
                for(int ch: freqCount[i]){
                    String str = "" + (char)ch;
                    res.append(str.repeat(i));
                }
            }
        }
        
        return res.toString();
    }
}