class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int greatest = 0;
        for(int num: candies) greatest = Math.max(greatest,num);
        
        List<Boolean> res = new ArrayList<>();
        
        for(int candy: candies){
            if(candy+extraCandies >= greatest) res.add(true);
            else res.add(false);
        }
        
        return res;
    }
}