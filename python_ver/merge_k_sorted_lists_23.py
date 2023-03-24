from typing import List, Optional
from queue import PriorityQueue

from python_ver.lc_structs import ListNode

setattr(ListNode, "__eq__", lambda self, other: self.val == other.val)
setattr(ListNode, "__lt__", lambda self, other: self.val < other.val)

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        list_pq = PriorityQueue(maxsize=0)
        for li in lists:
            if li:
                list_pq.put(li)

        result = pt = ListNode()
        while not list_pq.empty():
            pt.next = list_pq.get()
            pt = pt.next

            if pt.next:
                list_pq.put(pt.next)

        return result.next



