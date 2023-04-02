from collections import defaultdict


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        l, r, s_len, min_len, min_start = 0, 0, len(s), float('inf'), -1

        counts = {}
        for c in t:
            counts[c] = counts.get(c, 0) + 1
        missing = len(t)

        while r < s_len:
            if s[r] in counts:
                counts[s[r]] -= 1
                if counts[s[r]] >= 0:
                    missing -= 1
            r += 1

            while missing == 0:
                if r - l < min_len:
                    min_len = r - l
                    min_start = l

                if s[l] in counts:
                    counts[s[l]] += 1
                    if counts[s[l]] > 0:
                        missing += 1
                l += 1

        return s[min_start:min_start + min_len] if min_len != float('inf') else ''
