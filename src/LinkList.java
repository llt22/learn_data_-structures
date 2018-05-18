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
            return e.toString();
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
    }

    private Node getNode(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("get failed,  index is out of range");
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    // 注意获取的是指定节点里存储的数据
    public T get(int index) {
        return getNode(index).e;

    }

    public T getFirst() {
        return get(0);
    }

    public T getLast() {
        return get(size - 1);
    }

    public void set(int index, T e) {
        getNode(index).e = e;
    }

    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (e == getNode(i).e) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            Node n = getNode(i);
            s.append(n.toString() + " -> ");
        }
        s.append("null");
        return s.toString();
    }

    public void showList() {
        for (int i = 0; i < size; i++) {
            Node n = getNode(i);
            System.out.print("(" + n.e.toString() + ", " + "next: yes)" + " -> ");
        }
        System.out.print("null");
    }
}
