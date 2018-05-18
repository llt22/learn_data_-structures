public class LinkList<T> {
    private class Node {
        public T e;
        public Node next;

        public Node(T e, Node next) {
            this.next = next;
            this.e = e;
        }

        public Node(T e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            String s = "yes";
            if (next == null) {
                s = "null";
            }
            return "Node(data: " + e.toString() + ", next:" + s + ")";
        }
    }

    private Node head;
    private int size;

    public LinkList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T nodeData) {
        Node node = new Node(nodeData);
        node.next = head;
        head = node;
//        head = new Node(nodeData, head);
        size++;
    }

    public void addLast(T e) {
        Node newNode = new Node(e);
        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
        size++;
    }

    public void insert(int index, T e) {
        if (index == 0) {
            addFirst(e);
            return;
        }
        if (index > size || index < 0) {
            throw new IllegalArgumentException("get failed,  index is out of range");
        }

        Node newNode = new Node(e);
        int count = 1;
        Node left = head;
        Node right = null;

        while (left.next != null && count < index) {
            left = left.next;
            count++;
        }
        right = left.next;
        left.next = newNode;
        newNode.next = right;
        size++;
    }

    public Node getHead() {
        return head;
    }

    public void showList() {
        Node lastNode = head;
        System.out.println(lastNode);
        while (lastNode.next != null) {

            lastNode = lastNode.next;
            System.out.println(lastNode);
        }
    }

}
