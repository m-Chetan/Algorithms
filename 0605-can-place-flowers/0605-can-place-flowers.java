class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;
        for(int i=0;i<m;i++){
            if(flowerbed[i] == 0){
                int left = i-1>=0 ? flowerbed[i-1] : 0;
                int right = i+1<m ? flowerbed[i+1] : 0;
            
                if(left == 0 && right == 0){
                    flowerbed[i] = 1;
                    n--;
                } 
            }
        }
        
        return n<=0;
    }
}