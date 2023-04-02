from typing import List


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        height, width = len(matrix), len(matrix[0])
        row, col = 0, width - 1

        while row < height and col >= 0:
            if matrix[row][col] == target:
                return True
            elif matrix[row][col] < target:
                row += 1
            else:
                col -= 1

        return False

    # def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
    #     cols = len(matrix[0])
    #     start, end = 0, len(matrix) * cols - 1
    #
    #     if matrix[end // cols][end % cols] == target:
    #         return True
    #
    #     while start + 1 < end:
    #         mid = start + (end - start) // 2
    #
    #         row, col = divmod(mid, cols)
    #         if matrix[row][col] == target:
    #             return True
    #         elif matrix[row][col] < target:
    #             start = mid
    #         else:
    #             end = mid
    #
    #     return matrix[start // cols][start % cols] == target
