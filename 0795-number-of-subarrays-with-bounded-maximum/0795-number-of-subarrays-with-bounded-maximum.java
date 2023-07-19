class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        //x -> keep incrementing x if we get numbers in range
        // if num< left then we want to remove these subarrays from total subarrays
        // if num>right then rest x and y to 0;
        
        int x = 0, y = 0;
        int ans = 0;
        for(int num: nums){
            if(num<left){
                x++;
                y++;
            }
            else if(num>right){
                x = 0;
                y = 0;
            }
            else{
                x++;
                y = 0;
            }
            
            ans += x - y;
        }
        
        return ans;
    }
}