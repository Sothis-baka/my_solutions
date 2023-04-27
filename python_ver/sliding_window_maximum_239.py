from typing import List
from collections import deque


class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        cur_list, result = deque(), []

        for i, num in enumerate(nums):
            if cur_list and cur_list[0] + k <= i:
                cur_list.popleft()

            while cur_list and nums[cur_list[-1]] <= num:
                cur_list.pop()

            cur_list.append(i)
            if i + 1 >= k:
                result.append(nums[cur_list[0]])

        return result
