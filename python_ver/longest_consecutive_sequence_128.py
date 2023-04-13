from typing import List


class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        max_l = 0

        cache = set()
        for num in nums:
            cache.add(num)

        while cache:
            num = cache.pop()
            cur_l = 1

            pt = num + 1
            while pt in cache:
                cache.discard(pt)
                pt += 1
                cur_l += 1

            pt = num - 1
            while pt in cache:
                cache.discard(pt)
                pt -= 1
                cur_l += 1

            max_l = max(max_l, cur_l)

        return max_l
