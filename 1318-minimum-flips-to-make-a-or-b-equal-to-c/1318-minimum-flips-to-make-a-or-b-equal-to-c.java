class Solution {
    public int minFlips(int a, int b, int c) {
        int flip = 0;
        
        for(int i=0;i<32;i++){
            int x = a & (1<<i);
            int y = b & (1<<i);
            int z = c & (1<<i);
            
            if(z==0){
                if(x!=0) flip++;
                if(y!=0) flip++;
            }
            else{
                if(x!=0 || y!=0) continue;
                flip++;
            }
            
        }
        
        
        return flip;
    }
}