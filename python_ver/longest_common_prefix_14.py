from typing import List


class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        common_l = 0

        while common_l < len(strs[0]):
            ch = strs[0][common_l]
            for string in strs:
                if len(string) == common_l or string[common_l] is not ch:
                    return "" if common_l == 0 else strs[0][0:common_l]
            common_l += 1

        return strs[0]
