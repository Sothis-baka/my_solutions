from typing import Optional

from python_ver.lc_structs import ListNode


class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        start = pt = ListNode()
        pt.next = head

        while pt.next and pt.next.next:
            a, b = pt.next, pt.next.next
            pt.next, b.next, a.next = b, a, b.next
            pt = pt.next.next

        return start.next
