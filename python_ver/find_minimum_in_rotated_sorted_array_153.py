from typing import List


class Solution:
    def findMin(self, nums: List[int]) -> int:
        l_index, r_index = 0, len(nums) - 1

        while l_index + 1 < r_index:
            mid = (l_index + r_index) // 2
            if nums[mid] < nums[r_index]:
                r_index = mid
            else:
                l_index = mid

        return nums[r_index] if nums[l_index] > nums[r_index] else nums[l_index]
