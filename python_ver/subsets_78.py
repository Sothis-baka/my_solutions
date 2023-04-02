from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        nums_l = len(nums)
        result = []

        def dfs(index: int, cur_li: List[int]):
            if index == nums_l:
                result.append(cur_li)
                return

            end = index
            while end < nums_l and nums[end] == nums[index]:
                end += 1

            for i in range(index, end + 1):
                dfs(end, cur_li + nums[index:i])

        dfs(0, [])
        return result
