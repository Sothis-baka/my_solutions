from collections import Counter


class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        s1_l, s2_l = len(s1), len(s2)
        if s1_l > s2_l:
            return False

        s1_counts, cur_counts = Counter(s1), Counter(s2[:s1_l - 1])

        for index in range(s1_l - 1, s2_l):
            ch = s2[index]
            cur_counts[ch] += 1

            if s1_counts == cur_counts:
                return True

            ch = s2[index - s1_l + 1]
            cur_counts[ch] -= 1
            if not cur_counts[ch]:
                del cur_counts[ch]

        return False
