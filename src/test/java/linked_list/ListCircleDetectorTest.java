package linked_list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ListCircleDetectorTest {

    /**
     * Cycle in the list.
     * 1 (root) -> 2 -> 3 -> 4 -> 1 (root).
     */
    @Test
    void hasCycle() {

        ListCircleDetector<Integer> list = new ListCircleDetector<>();

        Node<Integer> root = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);

        root.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = root;

        boolean hasCircle = list.hasCycle(root);

        Assertions.assertTrue(hasCircle);

    }

    /**
     * No cycle in the list.
     * 1 (root) -> 2.
     */
    @Test
    void hasNoCycle() {

        ListCircleDetector<Integer> list = new ListCircleDetector<>();

        Node<Integer> root = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);

        root.next = node2;
        node2.next = null;

        boolean hasCircle = list.hasCycle(root);

        Assertions.assertFalse(hasCircle);

    }

}