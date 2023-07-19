class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
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