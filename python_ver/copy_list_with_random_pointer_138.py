from typing import Optional


class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random


class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        node_map = {}

        def cpy_node(node: Optional[Node]) -> Optional[Node]:
            if not node:
                return None

            if node not in node_map:
                node_map[node] = Node(node.val)
                node_map[node].next = cpy_node(node.next)
                node_map[node].random = cpy_node(node.random)

            return node_map[node]

        return cpy_node(head)
