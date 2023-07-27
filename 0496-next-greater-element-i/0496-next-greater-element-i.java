class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        Stack<Integer> stk = new Stack<>();
        for(int i=nums2.length-1;i>=0;i--){
            while(stk.size()>0 && stk.peek()<nums2[i]){
                stk.pop();
            }
            if(stk.size()>0) map.put(nums2[i],stk.peek());
            else map.put(nums2[i],-1);
            stk.push(nums2[i]);
        }
        
        int[] ans = new int[nums1.length];
        for(int i=0;i<ans.length;i++){
            ans[i] = map.get(nums1[i]);    
        }
        
        return ans;
    }
}