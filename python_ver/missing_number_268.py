from typing import List


class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        num_l = len(nums)

        return (1 + num_l) * num_l // 2 - sum(nums)

    # def missingNumber(self, nums: List[int]) -> int:
    #     nums.append(-1)
    #
    #     index, num_l = 0, len(nums)
    #     while index < num_l:
    #         val = nums[index]
    #         if val != index and val != -1:
    #             nums[index], nums[val] = nums[val], nums[index]
    #         else:
    #             index += 1
    #
    #     return nums.index(-1)
