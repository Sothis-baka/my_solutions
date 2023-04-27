from typing import Optional

from lc_structs import ListNode


class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        cache = {}

        pt = head
        while pt.next:
            cache[pt.next], pt = pt, pt.next

        while head != pt:
            if head.val != pt.val:
                return False
            if head.next == pt:
                break
            head, pt = head.next, cache[pt]

        return True
