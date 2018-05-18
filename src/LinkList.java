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

    private Node dummyHead;
    private int size;

    public LinkList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /*
     * 假的节点保证插入逻辑的统一性
     * 【dummyHead: null】-> 【head】-> 【33】-> 【54】-> 【45】-> 【44】
     * 因为我们找的是插入位置左边的节点，如果没有dummyHead, 当index=0, 也就是插入头Node就会出错
     * */
    public void insert(int index, T e) {

        if (index > size || index < 0) {
            throw new IllegalArgumentException("get failed,  index is out of range");
        }

        Node newNode = new Node(e);
        Node left = dummyHead;
        for (int i = 0; i < index; i++) {
            left = left.next;
        }

        Node right = left.next;
        left.next = newNode;
        newNode.next = right;
        size++;
    }

    public void addFirst(T e) {
        insert(0, e);
    }

    public void addLast(T e) {
        insert(size, e);
        size++;
    }


    public void showList() {
        Node nextNode = dummyHead.next;
        System.out.println(nextNode);

        while (nextNode.next != null) {
            nextNode = nextNode.next;
            System.out.println(nextNode);
        }
    }

}
