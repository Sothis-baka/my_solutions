from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        total, max_val = 0, float('-inf')

        for num in nums:
            total += num
            max_val = max(max_val, total)
            total = max(0, total)

        return max_val
