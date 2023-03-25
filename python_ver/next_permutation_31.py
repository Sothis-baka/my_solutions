from typing import List


class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Scan from right to left,
        Find the first element not in ascending order, swap it with the next larger number on the right, sort right part

        If nothing was found, sort all
        """
        i = len(nums) - 2

        while i >= 0 and nums[i] > nums[i + 1]:
            i -= 1

        if i >= 0:
            j = len(nums) - 1
            while j > i and nums[j] <= nums[i]:
                j -= 1
            nums[i], nums[j] = nums[j], nums[i]

        nums[i + 1:] = nums[i + 1:][::-1]
