from typing import Optional

from python_ver.lc_structs import ListNode


class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        prev = ListNode()
        prev.next = head

        slow = fast = prev

        for i in range(n):
            fast = fast.next

        while fast.next is not None:
            slow = slow.next
            fast = fast.next

        slow.next = slow.next.next

        return prev.next

