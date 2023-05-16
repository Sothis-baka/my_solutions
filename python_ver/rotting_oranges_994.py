from typing import List
from collections import deque


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        row, col, round = len(grid), len(grid[0]), 0
        dirs = [[0, -1], [0, 1], [-1, 0], [1, 0]]
        cur_list = deque()

        for i in range(row):
            for j in range(col):
                if grid[i][j] == 2:
                    cur_list.append((i, j))

        if not cur_list:
            if any(1 in row for row in grid):
                return -1
            return 0

        while cur_list:
            cur_len = len(cur_list)
            for _ in range(cur_len):
                i, j = cur_list.popleft()

                for di, dj in dirs:
                    new_i, new_j = i + di, j + dj
                    if 0 <= new_i < row and 0 <= new_j < col and grid[new_i][new_j] == 1:
                        grid[new_i][new_j] = 2
                        cur_list.append((new_i, new_j))

            round += 1

        if any(1 in row for row in grid):
            return -1

        return round - 1
