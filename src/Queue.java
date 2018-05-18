public interface Queue<T> {
    void enqueue(T item);

    T dequeue();

    T getFront();

    int getSize();

    boolean isEmpty();
}
