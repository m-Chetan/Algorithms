class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int ans = cost[n-1];
        int jump1 = cost[n-1];
        int jump2 = 0;
        
        for(int i=n-2; i>0; i--){
            int jump = cost[i] + Math.min(jump1,jump2);
            jump2 = jump1;
            jump1 = jump;
        }
        ans = Math.min(jump1,cost[0]+jump2);
        return ans;
    }
}