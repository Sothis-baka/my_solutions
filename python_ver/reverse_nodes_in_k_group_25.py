from typing import Optional

from python_ver.lc_structs import ListNode


class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        start = slow = fast = ListNode()
        start.next = head

        while fast:
            for i in range(k):
                fast = fast.next
                if not fast:
                    return start.next

            remain = fast.next
            pt = next_slow = slow.next

            for i in range(k):
                slow.next, pt.next, pt = pt, slow.next, pt.next

            slow = fast = next_slow
            slow.next = remain
