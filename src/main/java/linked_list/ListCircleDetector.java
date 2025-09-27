package linked_list;


import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class ListCircleDetector<V> {

    public ListCircleDetector() {
    }

    /**
     * hasCircle check if linked list has cycle detection.
     * @param root node.
     * @return true if it has cycle.
     */
    public boolean hasCycle(Node<V> root) {
        if (isNull(root) || isNull(root.next)) return false;

        Node<V> slow = root;
        Node<V> fast = root.next;

        while (nonNull(fast) && nonNull(fast.next)) {
            if (slow.equals(fast)) return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

}
