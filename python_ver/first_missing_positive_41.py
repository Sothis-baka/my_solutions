from typing import List


class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        size = len(nums)

        for i in range(size):
            while 1 <= nums[i] <= size and nums[nums[i] - 1] != nums[i]:
                nums[nums[i] - 1], nums[i] = nums[i], nums[nums[i] - 1]

        for i in range(size):
            if nums[i] != i + 1:
                return i + 1

        return size + 1

    # def firstMissingPositive(self, nums: List[int]) -> int:
    #     cache = set()
    #
    #     for num in nums:
    #         if 0 < num <= len(nums):
    #             cache.add(num - 1)
    #
    #     for i in range(len(nums)):
    #         if i not in cache:
    #             return i + 1
    #
    #     return len(nums) + 1
