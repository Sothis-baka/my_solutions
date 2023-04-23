class Node:
    def __init__(self, key: int = 0, val: int = 0):
        self.key, self.val = key, val
        self.prev, self.next = None, None


class LRUCache:
    def __init__(self, capacity: int):
        self.size = 0
        self.max_size = capacity

        self.value_map = {}

        self.start, self.end = Node(), Node()
        self.start.next, self.end.prev = self.end, self.start

    def get(self, key: int) -> int:
        val = -1
        if key in self.value_map:
            node = self.remove_node(self.value_map[key])
            val = node.val
            self.insert_at_start(node)

        return val

    def put(self, key: int, value: int):
        if key in self.value_map:
            node = self.remove_node(self.value_map[key])
            node.val = value
        else:
            node = Node(key, value)
        self.insert_at_start(node)
        self.remove_at_end()

    def insert_at_start(self, node: Node):
        self.start.next.prev, self.start.next, node.prev, node.next = node, node, self.start, self.start.next
        self.value_map[node.key] = node
        self.size += 1

    def remove_at_end(self):
        if self.size > self.max_size:
            node = self.end.prev
            node.prev.next, self.end.prev = self.end, node.prev
            self.value_map.pop(node.key)
            self.size -= 1

    def remove_node(self, node: Node) -> Node:
        node.prev.next, node.next.prev = node.next, node.prev
        self.value_map.pop(node.key)
        self.size -= 1
        return node
