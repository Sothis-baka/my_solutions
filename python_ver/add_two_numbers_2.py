from lc_structs import ListNode


class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        new_node = ListNode()
        pt = new_node
        carry_on = False

        while l1 is not None or l2 is not None:
            pt.next = ListNode(
                (l1.val if l1 is not None else 0) + (l2.val if l2 is not None else 0) + (1 if carry_on else 0)
            )
            pt = pt.next

            carry_on = pt.val >= 10
            pt.val %= 10

            if l1 is not None:
                l1 = l1.next
            if l2 is not None:
                l2 = l2.next

        if carry_on:
            pt.next = ListNode(1)

        return new_node.next



