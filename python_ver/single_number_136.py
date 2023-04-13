from typing import List


class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        visited = set()

        for num in nums:
            if num in visited:
                visited.remove(num)
            else:
                visited.add(num)

        return visited.pop()