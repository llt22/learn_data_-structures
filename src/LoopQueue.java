import java.util.Arrays;

public class LoopQueue<T> implements Queue<T> {
    private T[] array;
    private int front;
    private int tail;

    public LoopQueue(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public void enqueue(T item) {
        if(front==0 && tail ==array.length){
            resize();
        }
        if(tail-front ==1){
            resize();
        }
        array[tail] = item;
        tail++;
    }

    @Override
    public T dequeue() {
        T out = array[front];
        front++;
        return out;
    }

    @Override
    public T getFront() {
        return null;
    }

    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    private void resize() {
        T[] newArray = (T[]) new Object[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    @Override
    public String toString() {
        return Arrays.toString(array) + "front: " + front + "  tail: " + tail;
    }
}
