public class Main {
    public static void main(String[] args) {
        LinkListStack<Integer> stack = new LinkListStack<>();
        for (int i = 0; i < 4; i++) {
            stack.push(i);
        }
        stack.pop();
        stack.peak();
        System.out.println(stack);

    }
}

