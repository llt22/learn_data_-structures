import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Array<People> arr = new Array(10);


        People Jack = new People("Jack");

        arr.addLast(Jack);
        arr.addLast(Jack);
        arr.removeAllElements(Jack);

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
