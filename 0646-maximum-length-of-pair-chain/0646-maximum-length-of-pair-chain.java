class Solution {
    /* If we sort the array according to second element of pair then we just have to check for first element, Since first element is less than second.
        1) Sort the array according to right element
        2) For each pair just check if first element is greater than previous last element and increase the chain length by 1 
        3) After increasing length also change  last element to current last elemet
    
    */
    
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b) -> a[1]-b[1]);      //Sorting array according to right element
        
        int longestChain = 0;
        int currChain = Integer.MIN_VALUE;
        
        for(int i=0; i<pairs.length; i++){
            if(pairs[i][0]>currChain){
                longestChain++;
                currChain = pairs[i][1];
            }
        }
        
        return longestChain;
    }
}