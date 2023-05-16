from typing import List


class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        total = sum(nums)
        if total % 2 != 0:
            return False

        target = total // 2
        dp = [False] * (target + 1)
        dp[0] = True

        for num in nums:
            for possible_val in range(target, num - 1, -1):
                if dp[possible_val - num]:
                    dp[possible_val] = True

        return dp[target]
