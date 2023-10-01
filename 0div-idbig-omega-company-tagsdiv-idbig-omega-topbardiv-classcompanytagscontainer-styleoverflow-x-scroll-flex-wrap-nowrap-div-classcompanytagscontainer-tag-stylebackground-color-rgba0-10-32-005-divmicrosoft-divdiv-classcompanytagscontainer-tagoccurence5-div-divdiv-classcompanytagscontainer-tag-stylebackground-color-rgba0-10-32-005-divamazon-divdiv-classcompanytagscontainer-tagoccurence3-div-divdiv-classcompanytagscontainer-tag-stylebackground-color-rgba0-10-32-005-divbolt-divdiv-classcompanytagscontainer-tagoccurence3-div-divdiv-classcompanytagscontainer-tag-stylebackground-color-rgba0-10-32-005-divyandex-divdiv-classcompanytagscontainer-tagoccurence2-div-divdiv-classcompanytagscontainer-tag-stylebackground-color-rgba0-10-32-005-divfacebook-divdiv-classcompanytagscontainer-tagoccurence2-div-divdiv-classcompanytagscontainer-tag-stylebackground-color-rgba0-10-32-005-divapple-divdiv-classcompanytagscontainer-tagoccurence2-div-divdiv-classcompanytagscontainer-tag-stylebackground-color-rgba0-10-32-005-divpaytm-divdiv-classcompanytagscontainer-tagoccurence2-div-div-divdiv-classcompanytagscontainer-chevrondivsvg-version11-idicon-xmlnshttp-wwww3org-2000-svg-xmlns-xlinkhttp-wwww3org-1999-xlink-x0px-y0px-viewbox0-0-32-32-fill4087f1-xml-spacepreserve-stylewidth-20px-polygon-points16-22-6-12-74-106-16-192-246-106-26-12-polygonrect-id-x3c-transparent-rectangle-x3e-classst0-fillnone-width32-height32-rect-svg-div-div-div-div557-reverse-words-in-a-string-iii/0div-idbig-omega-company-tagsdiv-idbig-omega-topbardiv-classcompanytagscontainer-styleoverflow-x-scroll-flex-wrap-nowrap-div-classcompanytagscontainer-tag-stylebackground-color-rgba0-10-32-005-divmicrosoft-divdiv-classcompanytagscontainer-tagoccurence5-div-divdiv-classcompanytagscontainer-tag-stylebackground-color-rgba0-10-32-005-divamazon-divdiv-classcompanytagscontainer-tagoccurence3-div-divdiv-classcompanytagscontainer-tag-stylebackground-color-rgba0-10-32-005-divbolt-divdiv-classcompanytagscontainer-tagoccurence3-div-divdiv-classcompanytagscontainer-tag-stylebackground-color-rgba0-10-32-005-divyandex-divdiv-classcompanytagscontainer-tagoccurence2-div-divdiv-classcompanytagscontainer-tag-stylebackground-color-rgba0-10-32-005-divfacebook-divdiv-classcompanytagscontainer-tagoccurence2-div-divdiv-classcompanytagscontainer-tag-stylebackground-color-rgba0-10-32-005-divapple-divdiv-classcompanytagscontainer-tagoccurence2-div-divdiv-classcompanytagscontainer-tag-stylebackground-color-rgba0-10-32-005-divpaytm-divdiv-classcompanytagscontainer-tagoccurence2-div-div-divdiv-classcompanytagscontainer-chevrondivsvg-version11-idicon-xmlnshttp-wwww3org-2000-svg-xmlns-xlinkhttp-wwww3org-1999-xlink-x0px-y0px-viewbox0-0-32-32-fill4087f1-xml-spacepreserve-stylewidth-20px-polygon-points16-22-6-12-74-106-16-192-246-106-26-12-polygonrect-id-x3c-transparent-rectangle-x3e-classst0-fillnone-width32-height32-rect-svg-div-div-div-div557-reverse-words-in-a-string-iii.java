class Solution {
    public String reverseWords(String s) {
        String[] arr= s.split(" ");
        
        for(int i=0;i<arr.length;i++){
            StringBuilder sb = new StringBuilder(arr[i]);
            sb.reverse();
            arr[i] = sb.toString();
        }
        
        return String.join(" ",arr);
    }
}