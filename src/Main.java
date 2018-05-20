public class Main {
    public static void main(String[] args) {
        LinkList<String> list = new LinkList<>();
        for (int i = 0; i < 3; i++) {
            list.addFirst("hello");
        }
        list.addFirst("world");
        System.out.println(list);
        System.out.println(list.getFirst());
        System.out.println(list);
    }
}

