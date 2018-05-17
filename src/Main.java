import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Array<Integer> arr = new Array(4);
        for (int i = 0; i < 10; i++) {
            arr.addFirst(i);
        }

        System.out.println(arr);
    }
}

class People {
    private String name;

    People(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "obj__" + this.name;
    }
}
