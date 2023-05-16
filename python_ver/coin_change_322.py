import sys
from typing import List


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [-2] * (amount + 1)

        def dfs(remain: int) -> int:
            if remain < 0:
                return -1
            elif remain == 0:
                return 0

            if dp[remain] != -2:
                return dp[remain]

            dp[remain] = sys.maxsize
            for coin in coins:
                next_remain = remain - coin
                if next_remain >= 0:
                    next = dfs(next_remain)
                    if next != -1:
                        dp[remain] = min(dp[remain], 1 + next)

            if dp[remain] == sys.maxsize:
                dp[remain] = -1

            return dp[remain]

        return dfs(amount)


print(Solution().coinChange([1, 2, 5], 11))
