package linked_list;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * Task: Reverse a Singly Linked List
 * Description:
 * You are given a singly linked list.
 * Your task is to reverse the list in-place and return the new head of the list.
 * You should implement the solution in Java, Python, or your preferred language.
 * -------------------------------------------------------------------------------
 * Example:
 * Input: 1 -> 2 -> 3 -> 4 -> null
 * Output: 4 -> 3 -> 2 -> 1 -> null
 * -------------------------------------------------------------------------------
 * Requirements:
 * Reverse the list in-place (don’t create a new list).
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Edge cases: empty list (null) or single node.
 *
 * @param <T> type of the elements
 */
public class ReverseLinkedList<T> {

    Node<T> reverse(Node<T> head) {
        if (isNull(head) || isNull(head.next)) return head; // Edge cases: empty list or single node

        Node<T> current = head;
        Node<T> previous = null;
        Node<T> next;
                                        //  Input: 1 -> 2 -> 3 -> 4 -> null
                                        //  Output: 4 -> 3 -> 2 -> 1 -> null
        while (nonNull(current)) {      // | first step    |  last step
            next = current.next;        // |  2 -> 3       |   -> null
            current.next = previous;    // |  null <- 1    |   3 <- 4
            previous = current;         // |  1            |   4
            current = next;             // |  2            |   -> null
        }
        return previous;
    }

}
