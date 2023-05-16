from typing import List


class Solution:
    def findMissingRanges(self, nums: List[int], lower: int, upper: int) -> List[List[int]]:
        result = []

        last = lower - 1
        for num in nums:
            if num > last + 1:
                result.append([last + 1, num - 1])

            last = num

        if last < upper:
            result.append([last + 1, upper])

        return result
