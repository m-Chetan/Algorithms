class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if(t==1 && sx==fx && sy==fy) return false;
        if(Math.min(sx,fx)+t < Math.max(sx,fx) || Math.min(sy,fy)+t < Math.max(sy,fy)) return false;
        return true;
    }    
}