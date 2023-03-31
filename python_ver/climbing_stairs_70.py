class Solution:
    def climbStairs(self, n: int) -> int:
        cache = [0] * n

        def dfs(pos: int):
            if pos == n:
                return 1
            if pos > n:
                return 0

            if not cache[pos]:
                cache[pos] = dfs(pos + 1) + dfs(pos + 2)

            return cache[pos]

        return dfs(0)
