from typing import List


class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        l, r = -1, len(nums)

        while l + 1 < r:
            mid = l + (r - l) // 2
            if nums[mid] < target:
                l = mid
            elif nums[mid] > target:
                r = mid
            else:
                return mid

        return l + 1
