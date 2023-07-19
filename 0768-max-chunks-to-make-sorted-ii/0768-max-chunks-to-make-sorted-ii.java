class Solution {
    /* Create a min array to store min element in right of current index
        Number is in its sorted position if Max from left is less than the min in its right position
        if so then increase the counter
    */
    
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        
        int[] rightMin = new int[n];
        
        rightMin[n-1] = arr[n-1];
        
        for(int i=n-2;i>=0;i--) rightMin[i] = Math.min(arr[i], rightMin[i+1]);
        
        int count = 1;
        
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n-1;i++){
            max = Math.max(max,arr[i]);
            
            if(max <= rightMin[i+1]) count++;
        }
        
        return count;
    }
}