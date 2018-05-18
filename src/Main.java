public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i <5 ; i++) {
            stack.push(i);
        }
        stack.pop();
        System.out.println(stack.peak());
        System.out.println(stack);
    }
}

