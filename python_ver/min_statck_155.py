from sys import maxsize


class Node:
    def __init__(self, val, prev_min):
        self.val = val
        self.min_val = min(val, prev_min)
        self.prev = None


class MinStack:
    def __init__(self):
        self.stack = None

    def push(self, val: int) -> None:
        if not self.stack:
            self.stack = Node(val, maxsize)
        else:
            new_node = Node(val, self.stack.min_val)
            new_node.prev, self.stack = self.stack, new_node

    def pop(self) -> None:
        self.stack = self.stack.prev

    def top(self) -> int:
        return self.stack.val

    def getMin(self) -> int:
        return self.stack.min_val
