class Solution {
    public int maxChunksToSorted(int[] arr) {
        int jump = 0;
        int count = 0;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i] > jump) jump = arr[i];
            if(jump == i) count++;
        }
        
        return count;
    }
}