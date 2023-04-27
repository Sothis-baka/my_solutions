from typing import List


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        nums_l = len(nums)
        result = [1] * nums_l

        cur = 1
        for i, num in enumerate(nums):
            result[i] *= cur
            cur *= num

        cur = 1
        for i, num in enumerate(nums[::-1]):
            result[nums_l - 1 - i] *= cur
            cur *= num

        return result
