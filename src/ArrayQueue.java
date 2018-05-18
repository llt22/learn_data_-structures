public class ArrayQueue<T> implements Queue<T> {
    private Array<T> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    @Override
    public void enqueue(T item) {
        array.addLast(item);
    }

    @Override
    public T dequeue() {
        return array.removeFirst();
    }

    @Override
    public T getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("head [");
        for (int i = 0; i < array.getSize(); i++) {
            s.append(array.get(i));
            if(i!=array.getSize()-1){
                s.append(",");
            }
        }
        s.append("] tail");
        return s.toString();
    }
}
