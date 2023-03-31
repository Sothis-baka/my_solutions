from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        """
        Iterate from a side to another,
        current highest is n[i], new highest is n[j], missing area is (j - i) * (n[j] - n[i])
        Do it twice from different directions to complete the graph
        """
        missing_area = height[0]

        highest = 0
        for i in range(1, len(height)):
            if height[i] > height[highest]:
                missing_area += (i - 0) * (height[i] - height[highest])
                highest = i
            missing_area += height[i]

        highest = len(height) - 1
        for i in range(len(height) - 2, -1, -1):
            if height[i] > height[highest]:
                missing_area += (len(height) - 1 - i) * (height[i] - height[highest])
                highest = i

        return height[highest] * len(height) - missing_area
