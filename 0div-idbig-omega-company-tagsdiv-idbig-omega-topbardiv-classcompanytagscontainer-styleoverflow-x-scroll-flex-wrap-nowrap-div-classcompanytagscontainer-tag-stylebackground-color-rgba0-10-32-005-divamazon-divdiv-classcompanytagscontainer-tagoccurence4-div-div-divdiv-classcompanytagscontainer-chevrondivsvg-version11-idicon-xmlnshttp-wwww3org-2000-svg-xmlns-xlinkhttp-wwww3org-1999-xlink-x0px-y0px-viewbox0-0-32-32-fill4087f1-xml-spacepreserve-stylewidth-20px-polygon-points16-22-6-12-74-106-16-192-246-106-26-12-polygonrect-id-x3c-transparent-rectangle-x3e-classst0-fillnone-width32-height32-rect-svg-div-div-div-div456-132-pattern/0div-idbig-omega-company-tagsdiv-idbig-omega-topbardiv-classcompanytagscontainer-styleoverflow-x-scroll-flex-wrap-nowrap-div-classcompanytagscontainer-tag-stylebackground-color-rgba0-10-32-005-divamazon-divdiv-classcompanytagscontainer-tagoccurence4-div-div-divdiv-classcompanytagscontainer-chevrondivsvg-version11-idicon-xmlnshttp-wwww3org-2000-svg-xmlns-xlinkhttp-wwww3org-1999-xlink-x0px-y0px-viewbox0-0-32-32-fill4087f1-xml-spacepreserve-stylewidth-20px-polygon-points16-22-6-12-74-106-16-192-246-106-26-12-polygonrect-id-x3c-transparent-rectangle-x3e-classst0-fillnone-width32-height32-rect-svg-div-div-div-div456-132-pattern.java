class Solution {
    //Initialize kth ele to integer.min_value
    //stk will contain the jth element so if ith element is greater than jth then 
    //make jth ele to kth and ith to jth
    //if curr element is less than kthelement means we found the ans
    
    public boolean find132pattern(int[] nums) {
        int n=nums.length;
        int kthEle =  Integer.MIN_VALUE;
        
        Stack<Integer> stk = new Stack<>(); //to store jth element
        
        for(int i=n-1;i>=0;i--){
            if(nums[i]<kthEle) return true;
            
            while(stk.size()>0 && stk.peek()<nums[i]){
                kthEle = stk.pop();
            }
            
            stk.push(nums[i]);
        }
        
        return false;
    }
    
    //using minimum element from left and stack
//     public boolean find132pattern(int[] nums) {
//         int n = nums.length;
        
//         int[] leftSmallest = new int[n];

//         int smallest = nums[0];
//         for(int i=1;i<n;i++){
//             leftSmallest[i] = smallest;
//             smallest = Math.min(smallest,nums[i]);
//         }

//         Stack<Integer> stk = new Stack<>();
//         stk.push(nums[n-1]);
//         for(int i=n-2;i>0;i--){
//             if(nums[i]<=leftSmallest[i]) continue;
//             while(stk.size()>0 && stk.peek()<=leftSmallest[i]) stk.pop();
            
//             if(stk.size()>0 && stk.peek()<nums[i]) return true;
//             stk.push(nums[i]);
//         }
        
//         return false;
//     }
}