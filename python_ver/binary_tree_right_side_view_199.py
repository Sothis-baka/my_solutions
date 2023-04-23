from typing import Optional, List

from lc_structs import TreeNode


class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []

        def dfs(node: Optional[TreeNode], depth: int):
            if node:
                if depth == len(result):
                    result.append(node.val)
                else:
                    result[depth] = node.val
                dfs(node.left, depth + 1)
                dfs(node.right, depth + 1)

        dfs(root, 0)
        return result
