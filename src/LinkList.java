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

    // 时间复杂度 O(n)  期望复杂度 O(n/2)
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

    // 时间复杂度 O(1)
    public void addFirst(T e) {
        insert(0, e);
    }

    // 时间复杂度 O(n)
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
    // 时间复杂度 O(n)  期望复杂度 O(n/2)
    public T get(int index) {
        return getNode(index).e;

    }

    public T getFirst() {
        return get(0);
    }

    public T getLast() {
        return get(size - 1);
    }

    //    时间复杂度 O(n)  期望复杂度 O(n/2)
    public void set(int index, T e) {
        getNode(index).e = e;
    }

    //    时间复杂度 O(n)  期望复杂度 O(n/2)
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(getNode(i).e)) {
                return true;
            }
        }
        return false;
    }

    // 时间复杂度 O(n)  期望复杂度 O(n/2)
    public T removeNode(int index) {
        Node pre = null;
        if (index == 0) {
            pre = dummyHead;
        } else {
            pre = getNode(index - 1);
        }
        T e = pre.next.e;
        pre.next = pre.next.next;
        size--;
        return e;

    }

    //    时间复杂度 O(1)
    public T removeFirst() {
        return removeNode(0);
    }

    //    时间复杂度 O(n)
    public T removeLast() {
        return removeNode(size - 1);
    }

    public boolean removeElements(T e) {
        Node pre = dummyHead;
        while (pre.next != null) {
            if (pre.next.e == e) {
                pre.next = pre.next.next;
                size--;
            } else {
                pre = pre.next;
            }
        }
        return true;
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
