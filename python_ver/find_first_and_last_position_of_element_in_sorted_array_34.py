from typing import List


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def binary_search(left_bound: bool) -> int:
            l, r = -1, len(nums)

            while l + 1 < r:
                mid = l + (r - l) // 2

                if nums[mid] < target if left_bound else nums[mid] <= target:
                    l = mid
                else:
                    r = mid

            return l if left_bound else r

        left, right = binary_search(True), binary_search(False)
        return [left + 1 if 0 <= left + 1 < len(nums) and nums[left + 1] == target else -1,
                right - 1 if 0 <= right - 1 < len(nums) and nums[right - 1] == target else -1]
