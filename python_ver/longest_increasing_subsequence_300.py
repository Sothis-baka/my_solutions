import bisect
from typing import List


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        cur_list = []

        for num in nums:
            if not cur_list or num > cur_list[-1]:
                cur_list.append(num)
            else:
                index = bisect.bisect_left(cur_list, num)
                cur_list[index] = num

        return len(cur_list)
