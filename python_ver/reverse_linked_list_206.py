from typing import Optional

from lc_structs import ListNode


class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        new_list = None

        while head:
            head.next, head, new_list = new_list, head.next, head

        return new_list
