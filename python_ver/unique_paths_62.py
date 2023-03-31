class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        cache = [[1] * n for _ in range(m)]

        for i in range(1, m):
            for j in range(1, n):
                cache[i][j] = cache[i - 1][j] + cache[i][j - 1]

        return cache[m - 1][n - 1]
