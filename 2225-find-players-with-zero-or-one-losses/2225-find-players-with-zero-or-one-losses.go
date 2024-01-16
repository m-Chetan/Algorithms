class Solution {
public:
    vector<vector<int>> findWinners(vector<vector<int>>& matches) {
        vector<int> scores(100001, -1);
        int max_val = 0;

        for (const auto& match : matches) {
            int winner = match[0];
            int loser = match[1];
            max_val = std::max(max_val, std::max(winner, loser));
            if (scores[winner] == -1) scores[winner] = 0;
            if (scores[loser] == -1) scores[loser] = 1;
            else scores[loser]++;
        }

        vector<vector<int>> res(2);
        
        for (int i = 1; i <= max_val; ++i) {
            if (scores[i] == 0) res[0].push_back(i);
            if (scores[i] == 1) res[1].push_back(i);
        }

        return res;
    }
};

    