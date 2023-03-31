class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        len_1, len_2 = len(word1), len(word2)
        cache = [[None] * len_2 for _ in range(len_1)]

        def dfs(index1: int, index2: int):
            if index1 == len_1 or index2 == len_2:
                return max(len_1 - index1, len_2 - index2)

            if not cache[index1][index2]:
                # same
                if word1[index1] == word2[index2]:
                    return dfs(index1 + 1, index2 + 1)

                # add
                min_dist = dfs(index1, index2 + 1) + 1
                # replace
                min_dist = min(min_dist, dfs(index1 + 1, index2 + 1) + 1)
                # del
                min_dist = min(min_dist, dfs(index1 + 1, index2) + 1)

                cache[index1][index2] = min_dist

            return cache[index1][index2]

        return dfs(0, 0)
