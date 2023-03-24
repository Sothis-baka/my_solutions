from typing import List


class Solution:
    def __init__(self):
        self.result = []

    def generateParenthesis(self, n: int) -> List[str]:
        def generateHelper(cur: str, depth: int):
            if len(cur) == 2 * n:
                if depth == 0:
                    self.result.append(cur)
                return

            generateHelper(cur + '(', depth + 1)
            if depth > 0:
                generateHelper(cur + ')', depth - 1)

        self.result = []
        generateHelper("", 0)
        return self.result


