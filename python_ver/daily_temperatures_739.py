from typing import List


class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack, result = [], [0] * len(temperatures)

        for i, temperature in enumerate(temperatures):
            while stack and temperatures[stack[-1]] < temperature:
                day = stack.pop()
                result[day] = i - day

            stack.append(i)

        return result
