package linked_list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListTest {

    private static final ReverseLinkedList<Integer> reverser = new ReverseLinkedList<>();

    @Test
    void test_node_list_is_reversed() {
        var head = new Node<>(1);
        var node2 = new Node<>(2);
        var node3 = new Node<>(3);
        var node4 = new Node<>(4);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        Node<Integer> reversed = reverser.reverse(head);

        assertEquals(node4.value, reversed.value);
        assertEquals(node3.value, reversed.next.value);
        assertEquals(node2.value, reversed.next.next.value);
        assertEquals(head.value, reversed.next.next.next.value);
        assertNull(reversed.next.next.next.next);
    }

    @Test
    void test_null_head_return_the_same_null_object_return_back() {
        Node<Integer> head = null;

        Node<Integer> reversed = reverser.reverse(head);

        assertNull(reversed);
    }

    @Test
    void test_single_node_returned_back() {
        Node<Integer> head = new Node<>(1);

        Node<Integer> reversed = reverser.reverse(head);

        assertNotNull(reversed);
        assertEquals(reversed, head);
    }

}