class Solution(object):
    def longestPalindrome(self, s: str) -> str: 
        # start from any shortest one and expand as possible as one can
        # s[i : i + 1] -> s[i - 1 : i + 2] -> s[i - 2 : i + 3]
        # s[i : i + 2] -> s[i - 1 : i + 3] -> s[i - 2 : i + 4]

        max_len, max_str = 0, ""
        # odd
        for i in range(len(s)):
            l, r = self.expand_bond(s, i, i)
            if r - l - 1 > max_len:
                max_len = r - l - 1
                max_str = s[l + 1: r]

        # even
        for i in range(len(s) - 1):
            l, r = self.expand_bond(s, i, i + 1)
            if r - l - 1 > max_len:
                max_len = r - l - 1
                max_str = s[l + 1: r]

        return max_str

    def expand_bond(self, s: str, l: int, r: int) -> (int, int):
        while l >= 0 and r < len(s) and s[l] == s[r]:
            l, r = l - 1, r + 1

        return l, r

