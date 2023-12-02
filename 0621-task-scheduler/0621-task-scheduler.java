class Solution {
    public int leastInterval(char[] tasks, int n) {
        int m = tasks.length;
        if(n==0) return m;
        
        int[] freq = new int[26];
        
        for(char t: tasks) freq[t-'A']++;
        
        int[] freqCount = new int[m+1];
        
        for(int f: freq) freqCount[f]++;
       
        int i = 0;
        int res = 0;
        
        for(int j=m; j>0; j--){
            while(freqCount[j] != 0){
                res = Math.max(res, j*(n+1) -n + i);
                i++;
                freqCount[j]--;
            }
        }
        
        return res<m ? m : res;
    }
}