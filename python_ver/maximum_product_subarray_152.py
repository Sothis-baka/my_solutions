from typing import List


class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        result = nums[0]
        min_val = max_val = 0

        for num in nums:
            if num == 0:
                min_val, max_val = 0, 0
                result = max(result, 0)
                continue

            max_val, min_val = max(num, max_val * num, min_val * num), min(num, max_val * num, min_val * num)
            result = max(result, max_val)

        return result
