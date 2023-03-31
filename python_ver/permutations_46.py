from typing import List


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        result = []
        nums_l = len(nums)

        def backtrack(start: int):
            if start == nums_l:
                result.append(nums[:])
                return

            for i in range(start, nums_l):
                nums[i], nums[start] = nums[start], nums[i]
                backtrack(start + 1)
                nums[i], nums[start] = nums[start], nums[i]

        backtrack(0)
        return result
