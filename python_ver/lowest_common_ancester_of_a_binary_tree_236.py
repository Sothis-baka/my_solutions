from typing import Optional

from lc_structs import TreeNode


class Solution:
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> Optional[TreeNode]:
        def find(node: Optional[TreeNode]) -> Optional[TreeNode]:
            if not node:
                return None

            if node == p or node == q:
                return node

            left_res, right_res = find(node.left), find(node.right)

            if left_res and right_res:
                return node

            return left_res if left_res else right_res

        return find(root)
