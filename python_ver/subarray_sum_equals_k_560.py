from typing import List


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        occurrences, cur_sum, count = {0: 1}, 0, 0

        for num in nums:
            cur_sum += num

            count += occurrences.get(cur_sum - k, 0)
            occurrences[cur_sum] = occurrences.get(cur_sum, 0) + 1

        return count
