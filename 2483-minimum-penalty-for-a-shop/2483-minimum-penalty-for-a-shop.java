class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] left = new int[n+1];
        int[] right = new int[n+1];
        
        for(int i=1;i<=n;i++){
            left[i] = left[i-1] + (customers.charAt(i-1)=='N' ? 1:0);
        }
        
        for(int i=n-1;i>=0;i--){
            right[i] = right[i+1] + (customers.charAt(i)=='Y' ? 1:0);
        }
        
        int min = Integer.MAX_VALUE;
        int res = n+1;
        for(int i=0;i<=n;i++){
            if(left[i]+right[i]<min){
                res = i;
                min = left[i]+right[i];
            }
        }
        
        return res;
    }
}