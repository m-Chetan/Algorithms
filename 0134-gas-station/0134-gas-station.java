class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int tank = 0;
        int res = 0;
        int shortage = 0;
        
        for(int i=0;i<n;i++){
            tank += gas[i]-cost[i];
            if(tank<0){
                shortage += tank;
                tank = 0;
                res = i+1;
            }
 
        }
        if(tank<Math.abs(shortage)) return -1;
        return res%n;
    }
}