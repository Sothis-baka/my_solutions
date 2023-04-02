from typing import Optional

from lc_structs import TreeNode


class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def checkHelper(l_node: Optional[TreeNode], r_node: Optional):
            if not l_node or not r_node:
                return not l_node and not r_node

            if l_node.val != r_node.val:
                return False

            return checkHelper(l_node.left, r_node.right) and checkHelper(l_node.right, r_node.left)

        return checkHelper(root.left, root.right)
