from typing import List


class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        dir_index, dir_count = 0, 4
        height, width, row, col = len(matrix), len(matrix[0]), 0, 0

        result = []
        while len(result) < height * width:
            result.append(matrix[row][col])
            matrix[row][col] = None

            next_row, next_col = row + dirs[dir_index][0], col + dirs[dir_index][1]

            if not 0 <= next_row < height or not 0 <= next_col < width or not matrix[next_row][next_col]:
                dir_index = (dir_index + 1) % dir_count
                next_row, next_col = row + dirs[dir_index][0], col + dirs[dir_index][1]

            row, col = next_row, next_col

        return result
