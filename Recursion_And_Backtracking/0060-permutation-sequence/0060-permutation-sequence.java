class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        
        int fact = n;
        for(int i=1;i<n;i++){
            nums.add(i);
            fact *= i;
        }
        nums.add(n);
        
        k = k-1;
        
        String res = "";
        
        while(k>0 && n>0){
            fact /= n;
            
            int idx = k/fact;
            res += nums.get(idx);
            nums.remove(idx);
            k = k%fact;
            n--;
        }
        
        for(int num: nums) res += num; 
        
        return res;
    }
}