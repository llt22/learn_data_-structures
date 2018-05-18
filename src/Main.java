public class Main {
    public static void main(String[] args) {
        LinkList<Integer> list = new LinkList<>();
        list.addFirst(66);
        list.addFirst(100);
        list.addLast(29);
        list.insert(2,444444444);
        System.out.println(list.removeFirst());
        System.out.println(list);
    }
}

