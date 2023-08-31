class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] arr = new int[n+1];
        
        for(int i=0;i<=n;i++){
            int left = Math.max(0,i-ranges[i]);
            int right = Math.min(n,i+ranges[i]);
            
            arr[left] = Math.max(right,arr[left]);
        }
        
        int currEnd=0, maxEnd=0, taps=0;
        for(int i=0;i<=n;i++){
            if(i>currEnd){
                if(i>maxEnd) return -1;
                taps++;
                currEnd = maxEnd;
            }
            maxEnd = Math.max(maxEnd,arr[i]);
        }
        
        return taps;
    }
}