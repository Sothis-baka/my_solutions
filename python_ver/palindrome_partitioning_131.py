from typing import List


class Solution:
    def partition(self, s: str) -> List[List[str]]:
        s_l = len(s)
        is_palindrome_cache = [[None] * s_l for _ in range(s_l)]
        palindromes_cache = [None for _ in range(s_l)]

        def get_palindromes():
            for i in range(s_l):
                is_palindrome_cache[i][i] = True
                l, r = i - 1, i + 1
                while l >= 0 and r < s_l and s[l] == s[r]:
                    is_palindrome_cache[l][r] = True
                    l -= 1
                    r += 1

                l, r = i, i + 1
                while l >= 0 and r < s_l and s[l] == s[r]:
                    is_palindrome_cache[l][r] = True
                    l -= 1
                    r += 1

        def dfs(index: int) -> List[List[str]]:
            if index == s_l:
                return [[]]

            if not palindromes_cache[index]:
                palindromes = []

                for i in range(index, s_l):
                    if is_palindrome_cache[index][i]:
                        cur = s[index: i + 1]
                        next_list = dfs(i + 1)
                        palindromes += [[cur] + entry for entry in next_list]

                palindromes_cache[index] = palindromes

            return palindromes_cache[index]

        get_palindromes()
        return dfs(0)
