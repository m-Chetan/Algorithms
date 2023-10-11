class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int m = flowers.length, n = people.length;
        
        int[] start = new int[m];
        int[] end = new int[m];
        
        for(int i=0;i<m;i++){
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int[] res = new int[n];
        
        for(int i=0;i<n;i++){
            int upper = BSUpperBound(people[i],start);
            int lower = BSLowerBound(people[i],end);
            
            res[i] = upper-lower;
            
        }
        
        return res;
        
    }
    
    private int BSUpperBound(int target, int[] start){
        int low=0, high=start.length-1;
        
        while(low<=high){
            int mid = (low + high)/2;
            if(target>=start[mid]) low = mid+1;
            else high = mid-1;
        }
        
        return low;
    }
    
    private int BSLowerBound(int target, int[] end){
        int low=0, high=end.length-1;
        
        while(low <= high){ 
            
            int mid = (low + high)/2;
            if(target>end[mid]) low = mid+1;
            else high = mid-1;
        }
        
        return low;
    }
    
}