class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int sum = 0;
        
        for(int i=0;i<n;i++){
            int[] charFreq = new int[26];
            int[] countFreq = new int[n+1];
            int min = 1, max = 1;
            for(int j=i;j<n;j++){
                char ch = s.charAt(j);
                charFreq[ch-'a']++;
                int freq = charFreq[ch-'a'];
                if(freq == 1){
                    countFreq[1]++; 
                    min = 1;
                }
                else{
                    countFreq[freq]++;
                    countFreq[freq-1]--;
                    if(countFreq[min]==0) min++;
                    if(freq>max && countFreq[freq]==1) max++;
                }
              
                sum += (max-min);
            }     
            
        }
        
        
        
        return sum;
    }
}