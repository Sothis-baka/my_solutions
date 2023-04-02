from typing import List


class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        max_area = 0
        # ascending storage
        stack = [-1]

        for i, val in enumerate(heights):
            while stack[-1] != -1 and heights[stack[-1]] > val:
                height = heights[stack.pop()]
                max_area = max(max_area, height * (i - stack[-1] - 1))

            stack.append(i)

        while stack[-1] != -1:
            height = heights[stack.pop()]
            max_area = max(max_area, height * (len(heights) - stack[-1] - 1))

        return max_area
