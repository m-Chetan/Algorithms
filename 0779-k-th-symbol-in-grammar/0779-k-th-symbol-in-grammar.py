class Solution(object):
    def kthGrammar(self, n, k):
        if n == 1:
            return 0

        length = 1 << (n - 1)

        if k > length / 2:
            return 1 ^ self.kthGrammar(n - 1, k - length // 2)
        
        return self.kthGrammar(n - 1, k)
        