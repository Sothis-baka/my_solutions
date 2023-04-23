from typing import Optional

from lc_structs import ListNode


class Solution:
    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        def divide(node: ListNode):
            slow, fast = node, node.next
            while fast and fast.next:
                slow = slow.next
                fast = fast.next.next

            slow.next, temp = None, slow.next
            return node, temp

        def conquer(node: ListNode):
            if not node.next:
                return node

            left, right = divide(node)
            left = conquer(left)
            right = conquer(right)

            start = pt = ListNode()
            while left and right:
                if left.val < right.val:
                    pt.next = left
                    pt, left = pt.next, left.next
                else:
                    pt.next = right
                    pt, right = pt.next, right.next

            pt.next = left if left else right
            return start.next

        return conquer(head) if head else None
