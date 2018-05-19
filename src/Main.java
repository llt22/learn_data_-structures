public class Main {
    public static void main(String[] args) {
        LinkListQueue<Integer> queue = new LinkListQueue<>();
        for (int i = 0; i < 4; i++) {
            queue.enqueue(i);
        }
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);

    }
}

