from typing import List


class Vector2D:
    def __init__(self, vec: List[List[int]]):
        self.vec = [row for row in vec if row]
        self.i, self.j = 0, 0
        self.find_next_available()

    def next(self) -> int:
        val = self.vec[self.i][self.j]
        self.j += 1
        self.find_next_available()
        return val

    def hasNext(self) -> bool:
        return self.i < len(self.vec)

    def find_next_available(self):
        while self.i < len(self.vec) and self.j >= len(self.vec[self.i]):
            self.i, self.j = self.i + 1, 0
