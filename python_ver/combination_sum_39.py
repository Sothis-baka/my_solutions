from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []
        candidates.sort()

        # backtracking
        def backtracking(remain: int, cur: List[int], index: int):
            if remain == 0:
                result.append(cur.copy())
                return

            for i in range(index, len(candidates)):
                if candidates[i] > remain:
                    break
                cur.append(candidates[i])
                backtracking(remain - candidates[i], cur, i)
                cur.pop()

        backtracking(target, [], 0)
        return result
