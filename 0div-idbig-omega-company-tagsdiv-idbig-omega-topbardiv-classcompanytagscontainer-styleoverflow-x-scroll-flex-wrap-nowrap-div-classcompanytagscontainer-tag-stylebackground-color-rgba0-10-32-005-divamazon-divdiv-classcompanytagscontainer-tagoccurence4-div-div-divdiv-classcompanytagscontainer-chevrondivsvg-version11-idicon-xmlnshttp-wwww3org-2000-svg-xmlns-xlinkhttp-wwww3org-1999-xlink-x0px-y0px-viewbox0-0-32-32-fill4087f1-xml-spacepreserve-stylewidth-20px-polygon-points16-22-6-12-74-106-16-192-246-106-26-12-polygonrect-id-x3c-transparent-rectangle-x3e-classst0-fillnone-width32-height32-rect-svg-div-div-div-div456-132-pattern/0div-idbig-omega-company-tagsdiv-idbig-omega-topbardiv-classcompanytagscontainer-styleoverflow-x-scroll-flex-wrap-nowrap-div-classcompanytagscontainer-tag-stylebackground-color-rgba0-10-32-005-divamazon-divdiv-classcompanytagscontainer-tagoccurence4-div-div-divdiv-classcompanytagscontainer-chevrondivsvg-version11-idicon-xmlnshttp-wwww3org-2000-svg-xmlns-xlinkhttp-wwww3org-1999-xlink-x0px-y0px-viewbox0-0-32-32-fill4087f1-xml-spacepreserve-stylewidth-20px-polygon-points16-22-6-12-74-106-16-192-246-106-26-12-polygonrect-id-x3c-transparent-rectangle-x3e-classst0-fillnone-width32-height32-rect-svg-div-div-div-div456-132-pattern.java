class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        
        int[] leftSmallest = new int[n];

        int smallest = nums[0];
        for(int i=1;i<n;i++){
            leftSmallest[i] = smallest;
            smallest = Math.min(smallest,nums[i]);
        }

        Stack<Integer> stk = new Stack<>();
        stk.push(nums[n-1]);
        for(int i=n-2;i>0;i--){
            if(nums[i]<=leftSmallest[i]) continue;
            while(stk.size()>0 && stk.peek()<=leftSmallest[i]) stk.pop();
            
            if(stk.size()>0 && stk.peek()<nums[i]) return true;
            stk.push(nums[i]);
        }
        
        return false;
    }
}