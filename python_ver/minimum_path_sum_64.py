from typing import List


class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        height, width = len(grid), len(grid[0])
        cache = [[float('inf')] * width for _ in range(height)]
        cache[0][0] = grid[0][0]

        for i in range(height):
            for j in range(width):
                if i > 0:
                    cache[i][j] = min(cache[i][j], cache[i - 1][j] + grid[i][j])
                if j > 0:
                    cache[i][j] = min(cache[i][j], cache[i][j - 1] + grid[i][j])

        return int(cache[-1][-1])
