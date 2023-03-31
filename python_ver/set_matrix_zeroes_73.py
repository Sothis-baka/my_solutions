from typing import List


class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        cols = set()
        height, width = len(matrix), len(matrix[0])

        for i in range(height):
            for j in range(width):
                if matrix[i][j] == 0:
                    cols.add(j)

            if 0 in matrix[i]:
                matrix[i] = [0] * width

        for j in cols:
            for i in range(height):
                matrix[i][j] = 0
