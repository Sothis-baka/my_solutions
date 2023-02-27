class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        l, r, length, max_l = 0, 0, len(s), 0
        visited = set()
        while r < length:
            while s[r] in visited:
                visited.remove(s[l])
                l += 1
            visited.add(s[r])
            max_l = max(max_l, r - l + 1)
            r += 1

        return max_l
