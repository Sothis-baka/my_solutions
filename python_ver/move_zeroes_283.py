from typing import List


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        nums_l, l, index = len(nums), 0, 0

        while index < nums_l:
            if nums[index] != 0:
                nums[l], nums[index] = nums[index], nums[l]
                l += 1

            index += 1
