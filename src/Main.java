public class Main {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i <5 ; i++) {
            queue.enqueue(i);
        }
        queue.dequeue();
        System.out.println(queue);
    }
}

