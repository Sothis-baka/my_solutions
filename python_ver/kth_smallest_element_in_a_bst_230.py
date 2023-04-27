from typing import Optional, Tuple

from lc_structs import TreeNode


class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        def count_and_find(node: Optional[TreeNode], remain: int) -> Tuple[int, Optional[int]]:
            if not node:
                return 0, None

            left_count, left_val = count_and_find(node.left, remain)
            if left_val is not None:
                return 0, left_val

            if remain - left_count == 1:
                return 0, node.val

            right_count, right_val = count_and_find(node.right, remain - left_count - 1)
            if right_val is not None:
                return 0, right_val

            return 1 + left_count + right_count, None

        return count_and_find(root, k)[1]
