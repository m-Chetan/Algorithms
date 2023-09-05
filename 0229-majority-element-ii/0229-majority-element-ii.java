class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        int m1 = 0, m2 = 0;
        int c1 = 0, c2 = 0;
        
        for(int i=0; i<n; i++){
            if(nums[i]==m1) c1++;
            else if(nums[i]==m2) c2++;
            else if(c1==0){
                m1=nums[i];
                c1++;
            }
            else if(c2==0){
                m2=nums[i];
                c2++;
            }
            else{
                c1--;
                c2--;
            }
            
        }
       
        c1=0; c2=0;
        for(int i=0;i<n;i++){
            if(nums[i]==m1) c1++;
            if(nums[i]==m2) c2++;
        }
        
        if(c1>n/3) res.add(m1);
        if(c2>n/3 && m1!=m2) res.add(m2);
        
        return res;
    }
}