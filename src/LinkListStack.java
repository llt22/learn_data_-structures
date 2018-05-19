/*
 * 虽然 LinkListStack 入栈，出栈 时间复杂度是 O(1)
 * 但是相比ArrayStack, LinkListStack 有许多new 操作， 实际上可以更花时间
 * 再次强调，时间复杂度只描述增长趋势，不是说具体会花费多长时间
 * */
public class LinkListStack<T> implements Stack<T> {
    private LinkList<T> list;

    public LinkListStack() {
        list = new LinkList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(T e) {
        list.addFirst(e);
    }

    @Override
    public T pop() {
        return list.removeFirst();
    }

    @Override
    public T peak() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("top[");

        for (int i = 0; i < getSize(); i++) {
            T n = list.get(i);
            s.append(n.toString());
            if (i < getSize() - 1) {
                s.append(", ");
            }
        }
        s.append("]");
        return s.toString();
    }
}
