import heapq


class MedianFinder:
    def __init__(self):
        self.q1, self.q2 = [], []

    def addNum(self, num: int) -> None:
        heapq.heappush(self.q1, -heapq.heappushpop(self.q2, -num))

        if len(self.q1) > len(self.q2):
            heapq.heappush(self.q2, -heapq.heappop(self.q1))

    def findMedian(self) -> float:
        if len(self.q1) < len(self.q2):
            return -self.q2[0]
        else:
            return (self.q1[0] + -self.q2[0]) / 2
