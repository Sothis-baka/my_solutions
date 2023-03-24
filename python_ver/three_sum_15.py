from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        length, combinations = len(nums), []

        nums.sort()
        for i in range(length):
            if i > 0 and nums[i] == nums[i - 1]:
                i += 1
                continue

            val = nums[i]

            j, k = i + 1, length - 1

            while j < k:
                total = val + nums[j] + nums[k]

                if total == 0:
                    combinations.append([val, nums[j], nums[k]])
                    j += 1
                    while j < k and nums[j - 1] == nums[j]:
                        j += 1

                    k -= 1
                    while j < k and nums[k + 1] == nums[k]:
                        k -= 1
                elif total < 0:
                    j += 1
                    while j < k and nums[j - 1] == nums[j]:
                        j += 1
                else:
                    k -= 1
                    while j < k and nums[k + 1] == nums[k]:
                        k -= 1

        return combinations
