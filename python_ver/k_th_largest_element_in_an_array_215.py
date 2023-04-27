import heapq
from typing import List


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        cur_list = nums[:k]
        heapq.heapify(cur_list)

        for num in nums[k:]:
            if num > cur_list[0]:
                heapq.heapreplace(cur_list, num)

        return cur_list[0]
