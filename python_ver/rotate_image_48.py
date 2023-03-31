from typing import List, Tuple


class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        n = len(matrix)

        def get_new_pos(cur_pos: Tuple[int, int]) -> Tuple[int, int]:
            return cur_pos[0], n - 1 - cur_pos[1]

        for i in range(n):
            if i >= n / 2:
                break
            for j in range(n):
                if j >= n / 2:
                    break

                pos = (i, j)
                print(pos)
                last = 2000
                while matrix[pos[0]][pos[1]] < 2000:
                    new_pos = get_new_pos(pos)
                    last, matrix[pos[0]][pos[1]] = matrix[pos[0]][pos[1]], last

                    pos = new_pos

                matrix[pos[0]][pos[1]] = last


matrix = [[5, 1, 9, 11], [2, 4, 8, 10], [13, 3, 6, 7], [15, 14, 12, 16]]
Solution().rotate(matrix)
