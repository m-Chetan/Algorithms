class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int[] ans = new int[n];
        Arrays.sort(potions);
        
        for(int i=0;i<n;i++){
            int count = binarySearch(spells[i],success,potions);
            ans[i] = count;
        }
        
        return ans;
    }
    
    private int binarySearch(long x, long y, int[] potions){
        int low=0, high=potions.length-1;
        
        while(low<=high){
            int mid = (low+high)/2;
            
            if(potions[mid]*x >=y){
                high = mid-1;
            }
            else low = mid+1;
        }
        
        return potions.length-low;
        
    }
}