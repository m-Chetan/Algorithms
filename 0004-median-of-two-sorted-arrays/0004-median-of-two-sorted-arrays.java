class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if(n>m) return findMedianSortedArrays(nums2,nums1);
        
        int N = n + m;
        double median = 0;
        int low = 0, high = n;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            
            int lnums1 = mid-1 >=0 ? nums1[mid-1] : Integer.MIN_VALUE;
            int rnums1 = mid < n ? nums1[mid] : Integer.MAX_VALUE;
            int lnums2 = (N+1)/2 < (mid+1) ? Integer.MIN_VALUE : nums2[(N+1)/2 - mid - 1];
            int rnums2 = (N+1)/2 - mid >= nums2.length  ?  Integer.MAX_VALUE : nums2[(N+1)/2 - mid];
            
            if(lnums1 <= rnums2 && lnums2 <= rnums1){
                if(N%2 == 0){
                    int left = Math.max(lnums1,lnums2);
                    int right = Math.min(rnums1,rnums2);
                    return (left+right)/2.0;
                }
                else{
                    return Math.max(lnums1,lnums2);
                }
            }
            
            if(lnums1 > rnums2) high = mid-1;
            else low = mid+1;
            
            
        }
        
        return 0;
    }
}