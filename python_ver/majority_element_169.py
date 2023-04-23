from collections import defaultdict

from typing import List


class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        nums_l = len(nums)
        counts = defaultdict(lambda: 0)

        for num in nums:
            counts[num] = counts[num] + 1
            if counts[num] * 2 >= nums_l:
                return num

        return -1
