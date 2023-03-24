from typing import Optional

from python_ver.lc_structs import ListNode


class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        pt = head = ListNode()

        while list1 and list2:
            if list1.val < list2.val:
                pt.next = list1
                list1 = list1.next
            else:
                pt.next = list2
                list2 = list2.next

            pt = pt.next

        pt.next = list1 or list2

        return head.next
