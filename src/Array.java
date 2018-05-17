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

    public int find(int item) {
        for (int i = 0; i < size; i++) {
            if (data[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(int item) {
        int index = find(item);
        return index > 0;
    }

    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed,  index is out of range");
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return data[index];
    }

    public int removeFirst() {
        return remove(0);
    }

    public int removeLast() {
        return remove(size - 1);
    }

    public boolean removeElement(int item) {
        int index = find(item);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    public boolean removeAllElements(int item) {
        boolean isRemoved = removeElement(item);
        boolean isRemoveAll = false;
        while (isRemoved) {
            isRemoved = removeElement(item);
            isRemoveAll = true;
        }
        return isRemoveAll;
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
