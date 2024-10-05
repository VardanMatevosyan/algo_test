package stack;

class MinStack {
    int min = Integer.MAX_VALUE;
    int size;
    Node<Integer> head;
    Node<Integer> tail;


    public MinStack() {

    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);

        int min1 = minStack.getMin();
        System.out.println("Min1 " + min1);

        minStack.pop();
        System.out.println("Pop1");

        int min2 = minStack.getMin();
        System.out.println("Min2 " + min2);

        minStack.pop();
        System.out.println("Pop2");

        int min3 = minStack.getMin();
        System.out.println("Min3 "  + min3);

        minStack.pop();
        System.out.println("Pop3");

        int min4 = minStack.getMin();
        System.out.println("Min4 " + min4);

    }


    public void push(int val) {
        min = getMinValue(val);
        Node<Integer> newNode = new Node<Integer>(val);
        if (size > 0) {
            newNode.setMin(min);
            newNode.previous = tail;
            tail.next = newNode;
        } else {
            newNode.setMin(val);
            head = newNode;
        }
        tail = newNode;
        size++;
    }

    private Integer getMinValue(Integer val) {
        if (val < min) {
            return val;
        }
        return min;
    }

    public void pop() {
        if (size > 1) {
            Node<Integer> prev = tail.previous;
            tail = prev;
            min = tail.min;
        } else {
            tail = null;
            head = null;
        }
        size--;
    }

    public int top() {
        return tail.value;
    }

    public int getMin() {
        return tail.min;
    }

    private static class Node<Integer> {
        Integer value;
        Integer min;
        Node<Integer> next;
        Node<Integer> previous;

        public Node(Integer value) {
            this.value = value;
        }

        public void setMin(Integer min) {
            this.min = min;
        }
    }
}

