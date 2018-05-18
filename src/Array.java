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

    // 时间复杂度 O(1)
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed,  index is out of range");
        }
        return data[index];
    }
    public E getLast(){
        return get(size-1);
    }

    public void set(int index, E item) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed,  index is out of range");
        }
        data[index] = item;
    }

    // 时间复杂度 O(n)，index在 0-n之间，期望 O(n/2)
    public void insert(int index, E item) {
        if (size == data.length) {
            resize(2 * size);
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

    // 时间复杂度 O(1)，不执行insert中的 for 循环
    public void addLast(E item) {
        insert(size, item);
    }

    // 时间复杂度 O(n)，在头部添加元素后，整个数组都要移动，for 循环 n 次
    public void addFirst(E item) {
        insert(0, item);
    }

    // 时间复杂度 O(n)
    public int find(E item) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    // 时间复杂度 O(n)
    public boolean contains(E item) {
        int index = find(item);
        return index > 0;
    }

    // 时间复杂度 O(n) 期望 O(n/2)
    public E remove(int index) {
        // 均摊复杂度和防止复杂度的震荡
        if (size == data.length / 4 ) {
            resize(data.length / 2);
        }

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed,  index is out of range");
        }

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return data[index];
    }

    // 时间复杂度 O(n)
    public E removeFirst() {
        return remove(0);
    }

    // 时间复杂度 O(1)
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

    // 动态扩充数组长度 时间复杂度O(n) 时间复杂度只描述增长趋势
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
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
            return "[]"+"\ncapacity: " + data.length +
                    "    size: " + size;
        }
    }
}
