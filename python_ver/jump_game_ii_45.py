from typing import List
import sys


class Solution:
    def jump(self, nums: List[int]) -> int:
        # greedy
        farthest, level_ends = 0, 0
        depth = 0

        for i, val in enumerate(nums):
            if i > level_ends:
                depth += 1
                level_ends = farthest

            if level_ends >= len(nums) - 1:
                return depth

            farthest = max(farthest, i + val)

        return 0

    # def jump(self, nums: List[int]) -> int:
    #     # bfs
    #     nums_l = len(nums)
    #     # save the depth of each cell
    #     cache = [int(1e5) for _ in range(nums_l)]
    #     cache[0] = 0
    #
    #     for i, val in enumerate(nums):
    #         farthest = i + val
    #         for j in range(i+1, min(farthest+1, nums_l)):
    #             cache[j] = min(cache[j], cache[i] + 1)
    #             if j == nums_l - 1:
    #                 return cache[j]
    #
    #     return cache[nums_l - 1]

    # def jump(self, nums: List[int]) -> int:
    #     cache = [-1 for _ in range(len(nums))]
    #
    #     def dfs(pos: int) -> int:
    #         if pos == len(nums) - 1:
    #             return 0
    #
    #         if cache[pos] != -1:
    #             return cache[pos]
    #
    #         min_distance = len(nums)
    #         for i in range(1, nums[pos] + 1):
    #             if pos + i >= len(nums):
    #                 break
    #
    #             distance = dfs(pos + i)
    #             if distance >= 0:
    #                 min_distance = min(min_distance, distance)
    #
    #         cache[pos] = min_distance + 1
    #         return cache[pos]
    #
    #     return dfs(0)
