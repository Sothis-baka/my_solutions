from typing import Optional
from sys import maxsize

from lc_structs import TreeNode


class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def isValid(node: Optional[TreeNode], min_bound: int, max_bound: int) -> bool:
            if not min_bound < node.val < max_bound:
                return False

            return (not node.left or isValid(node.left, min_bound, node.val)) and (
                    not node.right or isValid(node.right, node.val, max_bound))

        return isValid(root, -maxsize - 1, maxsize)
