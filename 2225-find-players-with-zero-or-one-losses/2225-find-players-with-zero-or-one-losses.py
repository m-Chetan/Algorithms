class Solution:
    def findWinners(self, matches: List[List[int]]) -> List[List[int]]:
        scores = [-1] * 100001
        max_val = 0

        for match in matches:
            winner, loser = match[0], match[1]
            max_val = max(max_val, max(winner, loser))
            if scores[winner] == -1:
                scores[winner] = 0
            if scores[loser] == -1:
                scores[loser] = 1
            else:
                scores[loser] += 1

        winners = [i for i in range(1, max_val + 1) if scores[i] == 0]
        losers = [i for i in range(1, max_val + 1) if scores[i] == 1]

        return [winners, losers]