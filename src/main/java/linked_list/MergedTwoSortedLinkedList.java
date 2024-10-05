package linked_list;

class MergedTwoSortedLinkedList {

    public static void main(String[] args) {
        ListNode list1Node1 = new ListNode(1);
        ListNode list1Node2 = new ListNode(2);
        ListNode list1Node3 = new ListNode(4);
        list1Node1.next = list1Node2;
        list1Node2.next = list1Node3;

        ListNode list2Node1 = new ListNode(1);
        ListNode list2Node2 = new ListNode(2);
        ListNode list2Node3 = new ListNode(3);
        ListNode list2Node4 = new ListNode(4);
        list2Node1.next = list2Node2;
        list2Node2.next = list2Node3;
        list2Node3.next = list2Node4;

        print("First list ", list1Node1);
        print("Second list ", list2Node1);

        MergedTwoSortedLinkedList solution = new MergedTwoSortedLinkedList();
        ListNode listNode = solution.mergeTwoLists(list1Node1, list2Node1);
        print("After merging both lists ", listNode);
    }

    private static void print(String description, ListNode listNode) {
        StringBuilder builder = new StringBuilder();
        builder.append(description);
        builder.append(" ");
        while (listNode != null) {
            builder.append(listNode.val);
            builder.append(" ");
            listNode = listNode.next;
        }
        System.out.println("Result " + builder.toString());
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode result = temp;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                result.next = l1;
                l1 = l1.next;
            } else {
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
        }

        while (l1 != null) {
            result.next = l1;
            l1 = l1.next;
            result = result.next;
        }

        while (l2 != null) {
            result.next = l2;
            l2 = l2.next;
            result = result.next;
        }

        return temp.next;
    }



    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}