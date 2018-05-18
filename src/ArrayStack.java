public class ArrayStack<T> implements Stack<T> {

    Array<T> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
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
    public void push(T e) {
        array.addLast(e);
    }

    @Override
    public T pop() {
        return array.removeLast();
    }

    @Override
    public T peak() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < array.getSize(); i++) {
            s.append(array.get(i));
            if(i!=array.getSize()-1){
                s.append(",");
            }
        }
        s.append("] top");
        return s.toString();
    }
}
