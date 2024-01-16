class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] scores = new int[100001];
        Arrays.fill(scores,-1);
        int max = 0;
        
        for(int[] match : matches){
            int winner = match[0];
            int loser = match[1];
            max = Math.max(max,Math.max(winner,loser));
            if(scores[winner]==-1) scores[winner] = 0;
            if(scores[loser]==-1) scores[loser] = 1;
            else scores[loser]++;
        }
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> winners = new ArrayList<>();
        List<Integer> losers = new ArrayList<>();
        
        for(int i=1;i<=max;i++){
            if(scores[i]==0) winners.add(i);
            if(scores[i]==1) losers.add(i);    
        }
        
        res.add(winners);
        res.add(losers);
        
        return res;
    }
}