from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        money = (0, 0)

        for num in nums:
            money = (money[1] + num, max(money))

        return max(money)
