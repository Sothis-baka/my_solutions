from collections import defaultdict
from typing import List


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        pre_reqs = defaultdict(lambda: [])
        for course, pre_req in prerequisites:
            pre_reqs[course].append(pre_req)

        visited = [None] * numCourses

        def is_completable(index: int) -> bool:
            if visited[index] is not None:
                return visited[index]

            visited[index] = False
            for course in pre_reqs[index]:
                if not is_completable(course):
                    return False

            visited[index] = True
            return True

        for course in range(numCourses):
            if not is_completable(course):
                return False

        return True
