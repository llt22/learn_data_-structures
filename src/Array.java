import java.util.Arrays;

public class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
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

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed,  index is out of range");
        }
        return data[index];
    }

    public void set(int index, E item) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed,  index is out of range");
        }
        data[index] = item;
    }

    public void insert(int index, E item) {
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

    public void addLast(E item) {
        insert(size, item);
    }

    public void addFirst(E item) {
        insert(0, item);
    }

    public int find(E item) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(E item) {
        int index = find(item);
        return index > 0;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed,  index is out of range");
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return data[index];
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public boolean removeElement(E item) {
        int index = find(item);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    public boolean removeAllElements(E item) {
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
            String arr = "[";
            for (int i = 0; i < size; i++) {
                String a = "";
                if (i == size - 1) {
                    a = data[i] + "]";
                } else {
                    a = data[i] + ",";
                }

                arr += a;
            }
            String s = arr +
                    "\ncapacity: " + data.length +
                    "    size: " + size;

            return s;
        } else {
            return "[]";
        }
    }
}
