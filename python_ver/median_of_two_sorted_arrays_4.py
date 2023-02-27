class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """

        count, total_count = 0, len(nums1) + len(nums2)

        if total_count % 2 == 1:
            is_odd, mid = True, int(total_count / 2)
        else:
            is_odd, mid = False, int(total_count / 2 - 1)

        i1, i2 = 0, 0
        for i in range(mid):
            if i2 >= len(nums2) or (i1 < len(nums1) and nums1[i1] <= nums2[i2]):
                i1 += 1
            else:
                i2 += 1

        result = 0.0
        for i in range(1 if is_odd else 2):
            if i2 >= len(nums2) or (i1 < len(nums1) and nums1[i1] < nums2[i2]):
                result, i1 = result + nums1[i1], i1 + 1
            else:
                result, i2 = result + nums2[i2], i2 + 1

        return result if is_odd else result / 2


print(Solution().findMedianSortedArrays([1, 2], [3, 4]))

