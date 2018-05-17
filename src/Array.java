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
