package linked_list_cycle_ii_142;

/*
    Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
    There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
    Do not modify the linked list.
 */
public class Main {
    /*
        If we have a n length list.
        Use two pointers fast and slow point to head.
        Fast speed is 2, slow speed is 1.
        If there is no cycle, they won't meet. Result is 1
        If there is a cycle at index j to index i.
        suppose they meet at k

        2(k - i) - (k-i) = (k - i)
     */
}
