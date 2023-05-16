from typing import Optional

from lc_structs import TreeNode


class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        def dfs(node: Optional[TreeNode]) -> (int, int):
            # Return the maximum length in the tree with node as root, and the depth of the tree
            if not node:
                return 0, 0

            left_length, left_depth = dfs(node.left)
            right_length, right_depth = dfs(node.right)

            max_length = max(left_length, right_length, left_depth + right_depth + 1)
            max_depth = max(left_depth, right_depth) + 1

            return max_length, max_depth

        return dfs(root)[0] - 1
