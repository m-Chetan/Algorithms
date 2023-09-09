class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
         
        
        while (sx < tx && sy < ty){ 
            if (tx < ty) ty %= tx;
            else tx %= ty;
         }
        
        //if first number s is matching with first number t then 
        //to make second number of t the first number should be multiple of it
        if(sx == tx && sy <= ty && (ty - sy) % sx == 0) return true;
            
        return sy == ty && sx <= tx && (tx - sx) % sy == 0;
    }
}