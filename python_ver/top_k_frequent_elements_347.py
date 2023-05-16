from typing import List
from collections import defaultdict


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        counts = {}

        for num in nums:
            counts[num] = counts.get(num, 0) + 1

        cur_list = [(-count, num) for num, count in counts.items()]
        cur_list.sort()

        return [entry[1] for entry in cur_list[:k]]
