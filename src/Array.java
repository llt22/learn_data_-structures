import java.util.Arrays;

public class Array {
    private int[] data;
    private int size;

    public Array(int capacity) {
        this.data = new int[capacity];
        this.size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getCapacity() {
        return data.length;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed,  index is out of range");
        }
        return data[index];
    }

    public void set(int index, int item) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed,  index is out of range");
        }
        data[index] = item;
    }

    public void insert(int index, int item) {
        if (size == data.length) {
            throw new IllegalArgumentException("addLast failed, array is full");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("insert failed,  insert position is out of range");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = item;
        size++;
    }

    public void addLast(int item) {
        insert(size, item);
    }

    public void addFirst(int item) {
        insert(0, item);
    }

    @Override
    public String toString() {
        if (size != 0) {
            String arr = Arrays.toString(this.data);
            String subArr = arr.substring(0, 3 * size - 1) + "]";
            String s = subArr +
                    "\ncapacity: " + data.length +
                    "    size: " + size;

            return s;
        } else {
            return "[ ]";
        }
    }
}
