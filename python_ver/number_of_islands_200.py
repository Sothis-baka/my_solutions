from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        height, width = len(grid), len(grid[0])
        visited = [[False] * width for _ in range(height)]
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        count = 0

        def dfs(row: int, col: int):
            visited[row][col] = True

            for dr, dc in dirs:
                new_r, new_c = row + dr, col + dc

                if 0 <= new_r < height and 0 <= new_c < width \
                        and grid[new_r][new_c] == "1" and not visited[new_r][new_c]:
                    dfs(new_r, new_c)

        for i in range(height):
            for j in range(width):
                if grid[i][j] == "1" and not visited[i][j]:
                    dfs(i, j)
                    count += 1

        return count
