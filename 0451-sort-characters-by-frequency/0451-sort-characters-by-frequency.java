class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        
        //There are total 256 characters possible lower + upper + digits + special symbol 
        //Count frequency of each character
        int[] freq = new int[256];
        for(char ch:s.toCharArray()) freq[ch]++;
        
        //create an array of array list that stores frequecy and add characters in list which have that frequency
        //E.g  aabbc  2->[a,b] and 1->[c] 
        ArrayList<Integer>[] freqCount = new ArrayList[n+1];
        for(int i=0;i<=n;i++) freqCount[i] = new ArrayList<>();
        
        for(int i=0;i<256;i++){
            if(freq[i] != 0){
                freqCount[freq[i]].add(i);
            }
        } 
        
        StringBuilder res = new StringBuilder();
        
        //Traverse from end since its the highest frequecy and we want to sort in decreasing
        
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