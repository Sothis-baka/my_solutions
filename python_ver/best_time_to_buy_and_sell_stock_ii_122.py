from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        cur_without, cur_with = 0, -prices[0]

        for price in prices[1:]:
            cur_without, cur_with = max(cur_without, cur_with + price), max(cur_with, cur_without - price)

        return max(cur_without, cur_with + prices[-1])
