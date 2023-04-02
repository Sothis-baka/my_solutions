from typing import Optional, List
from collections import deque

from lc_structs import TreeNode


class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []

        result = []
        candidates = deque()
        candidates.append(root)

        while candidates:
            result.append([])

            for _ in range(len(candidates)):
                node = candidates.popleft()
                result[-1].append(node.val)

                if node.left:
                    candidates.append(node.left)
                if node.right:
                    candidates.append(node.right)

        return result
