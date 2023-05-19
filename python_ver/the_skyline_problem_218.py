from typing import List
import heapq


class Solution:
    def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
        result = []

        points = []
        for building in buildings:
            points.append((building[0], -building[2]))
            points.append((building[1], building[2]))

        points.sort()

        cur_height, cur_list = 0, [0]
        for point in points:
            if point[1] < 0:
                heapq.heappush(cur_list, point[1])
            else:
                cur_list.remove(-point[1])
                heapq.heapify(cur_list)

            if cur_height != cur_list[0]:
                result.append([point[0], -cur_list[0]])
                cur_height = cur_list[0]

        return result
