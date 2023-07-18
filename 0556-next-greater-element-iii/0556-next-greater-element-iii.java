class Solution {
    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        
        int N = s.length();
        int[] nums = new int[N];
        
        for(int i=0;i<N;i++){
            nums[i] = s.charAt(i) -'0';
        } 
        
        int i = N-1;
        while(i>0 && nums[i] <= nums[i-1]){ 
            i--;
        }
        
        if(i==0) return -1;
        
        int idx = findNextGreater(nums,i-1);
        swap(nums,i-1,idx);
        reverse(nums,i,N-1);
        
        String res = "";
        for(int e: nums) res += e;
        
        Long ans = Long.valueOf(res);
        if(ans > Integer.MAX_VALUE) return -1;
        return ans.intValue();
    }
    
    private int findNextGreater(int[] nums,int idx){
        int max = Integer.MAX_VALUE;
        int nextGreater = idx;
        
        for(int i=idx+1;i<nums.length;i++){
            if(nums[i] > nums[idx] && nums[i] <= max) {
                nextGreater = i;
                max = nums[i];
            }
        }
        return nextGreater;
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int i, int j){
        while(i<j){
            swap(nums,i,j);
            i++; j--;
        }
    }
}