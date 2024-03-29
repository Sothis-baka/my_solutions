from typing import Optional

from lc_structs import ListNode


class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        slow = fast = head

        while fast and fast.next:
            slow, fast = slow.next, fast.next.next

            if slow == fast:
                while head != slow:
                    head, slow = head.next, slow.next
                return head

        return None
