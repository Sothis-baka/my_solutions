from typing import List


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        visited = set()
        s_len = len(s)

        def dfs(index: int):
            if index in visited:
                return False

            remain_s = s[index:]
            for word in wordDict:
                if remain_s.startswith(word):
                    next_i = index + len(word)
                    if next_i == s_len or dfs(next_i):
                        return True

            visited.add(index)
            return False

        return dfs(0)
