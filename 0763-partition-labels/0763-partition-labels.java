class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] lastOccurence = new int[26];
    
        for(int i=0;i<n;i++){
            int ch = s.charAt(i)-'a';
            lastOccurence[ch] = i;
        }
        
        List<Integer> res = new ArrayList<>();
        
        int maxJump = 0;
        int start = -1;
        for(int i=0;i<n;i++){
            int ch = s.charAt(i)-'a';
            maxJump = Math.max(maxJump,lastOccurence[ch]);
            
            if(i == maxJump){
                res.add(i-start);
                maxJump = 0;
                start = i;
            }
        }
        
        return res;
    }
}