from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:
        l_index, r_index = 0, len(height) - 1
        max_area = 0

        while l_index < r_index:
            max_area = max(max_area, min(height[l_index], height[r_index]) * (r_index - l_index))

            if height[l_index] > height[r_index]:
                r_index -= 1
            else:
                l_index += 1

        return max_area
