/*
 * 给链表加上尾指针
 * 链表头部插入和删除元素时间复杂度都是 O(1)
 * 删除尾部元素，得通过尾部元素的上一个元素来删除，时间复杂度是 O(n)， 插入元素是 O(1)
 * 所有尾部用来入队，头部用来出队
 *
 * */
public class LinkListQueue<T> implements Queue<T> {

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
    private Node head;
    private Node tail;
    private int size;

    public LinkListQueue() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    @Override
    public void enqueue(T item) {
        Node n = new Node(item);

        if (tail == null) {
            head = n;
            tail = n;
            /*
             * 注意顺序
             * dummyHead.next = head(null);
             * head = n;
             * 这种顺序，dummyHead.next 永远指向 null, 赋值是拷贝对象地址
             * */
            dummyHead.next = head;
            size = 1;
            return;
        }

        tail.next = n;
        tail = n;
        size++;

    }

    @Override
    public T dequeue() {
        if (size == 0) {
            throw new IllegalArgumentException("dequeue failed,  queue is empty");
        }
        Node n = head;
        dummyHead.next = head.next;
        head = head.next;
        size--;
        return n.e;
    }

    @Override
    public T getFront() {
        if (size == 0) {
            throw new IllegalArgumentException("dequeue failed,  queue is empty");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("<- [");
        Node n = dummyHead.next;

        for (int i = 0; i < size; i++) {
            s.append(n.e);
            if (i < size - 1) {
                s.append(", ");
            }
            n = n.next;
        }
        s.append("] <-");
        return s.toString();
    }
}
