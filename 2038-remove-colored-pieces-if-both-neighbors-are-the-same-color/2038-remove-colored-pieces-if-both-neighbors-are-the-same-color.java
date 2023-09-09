class Solution {
    public boolean winnerOfGame(String colors) {
        int n = colors.length();
        int alice = 0;
        
        for(int i=1;i<n-1;i++){
            char ch = colors.charAt(i);
            if(colors.charAt(i)==colors.charAt(i-1) && colors.charAt(i)==colors.charAt(i+1)){
                if(colors.charAt(i)=='A') alice++;
                else alice--;
            }
        }
        
        return alice>0;
    }
}