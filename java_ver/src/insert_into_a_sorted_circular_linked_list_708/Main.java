package insert_into_a_sorted_circular_linked_list_708;

class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
}
public class Main {
    public Node insert(Node head, int insertVal) {
        /* Empty */
        if (head == null) {
            Node newNode = new Node(insertVal);
            newNode.next = newNode;
            return newNode;
        }

        /* Only one element */
        if (head.next == head) {
            head.next = new Node(insertVal, head);
        } else {
            Node pt = head;
            do {
                if((pt.val <= insertVal && pt.next.val >= insertVal)
                || pt.next.val < pt.val && (pt.val <= insertVal || pt.next.val >= insertVal)) break;
                pt = pt.next;
            }while (pt.next != head);
            pt.next = new Node(insertVal, pt.next);
        }

        return head;
    }
}
