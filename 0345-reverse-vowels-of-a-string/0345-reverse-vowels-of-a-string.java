class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length-1;
        int i=0, j=n;
        
        while(i<j){
            if(isVowel(arr[i]) && isVowel(arr[j])){
                char temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++; j--;
            }
            if(!isVowel(arr[i])) i++;
            if(!isVowel(arr[j])) j--;
        }
        
        return new String(arr);
    }
    
    private boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U' ) return true;
        return false;
    }
}