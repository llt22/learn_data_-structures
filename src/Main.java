import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Array<Integer> arr = new Array(4);
        for (int i = 0; i < 3; i++) {
            arr.addFirst(i);
        }

        arr.remove(0);
        arr.remove(0);
        arr.remove(0);
        arr.addLast(10);
        arr.addLast(10);
        arr.addLast(10);
        arr.remove(0);
        arr.remove(0);
        arr.remove(0);
        System.out.println(arr.getCapacity());

        System.out.println(arr);
    }
}

