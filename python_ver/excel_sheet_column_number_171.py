class Solution:
    def titleToNumber(self, columnTitle: str) -> int:
        result, a_val = 0, ord('A')

        for ch in columnTitle:
            result *= 26
            result += ord(ch) - a_val + 1

        return result
