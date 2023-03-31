from typing import List


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        result = []

        def backtrack(row: int, cols: List[int], diags: List[int], anti_diags: List[int]):
            if row == n:
                result.append(['.' * i + 'Q' + '.' * (n - i - 1) for i in cols])
                return

            for col in range(n):
                if col not in cols and row + col not in diags and row - col not in anti_diags:
                    cols.append(col)
                    diags.append(row + col)
                    anti_diags.append(row - col)

                    backtrack(row + 1, cols, diags, anti_diags)

                    cols.pop()
                    diags.pop()
                    anti_diags.pop()

        backtrack(0, [], [], [])
        return result
