from typing import List


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        result = []

        counts = [0] * 26
        a_val = ord('a')
        for ch in p:
            counts[ord(ch) - a_val] += 1

        cur_counts = [0] * 26
        for ch in s[:len(p)]:
            cur_counts[ord(ch) - a_val] += 1

        for index in range(len(p), len(s) + 1):
            if cur_counts == counts:
                result.append(index - len(p))

            if index != len(s):
                cur_counts[ord(s[index]) - a_val] += 1
                cur_counts[ord(s[index - len(p)]) - a_val] -= 1

        return result
