class Solution {
    public int maxVowels(String s, int k) {
        int maxVowel = 0;
        int start = 0;
        int count = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(i>=k){
                maxVowel = Math.max(maxVowel,count);
                if(isVowel(s.charAt(start))) count--;
                start++;
            }
            if(isVowel(ch)) count++;
        }
        maxVowel = Math.max(maxVowel,count);
        return maxVowel;
    }
    
    private boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' ||ch == 'i' ||ch == 'o' ||ch == 'u') return true;
        return false;
    }
}