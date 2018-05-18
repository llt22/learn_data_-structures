public class Main {
    public static void main(String[] args) {
        LinkList<Integer> list = new LinkList<>();
        list.addFirst(66);
        list.addFirst(100);
        list.addLast(29);
        list.insert(2,444444444);
        list.set(2,44);
        System.out.println(list.contains(10));
        System.out.println(list);
        list.showList();
    }
}

