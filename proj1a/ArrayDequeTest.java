public class ArrayDequeTest {


    public static void test1() {
        ArrayDeque<Integer> deque = new ArrayDeque();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);
        System.out.println(deque.get(3));
        deque.addLast(5);
        deque.addLast(6);
        deque.addFirst(7);
        System.out.println(deque.get(3));
        System.out.println(deque.get(6));
        deque.addFirst(8);
        deque.printDeque();
        deque.addLast(6);
        deque.addFirst(6);
        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();
        deque.removeLast();
        deque.removeFirst();
        deque.printDeque();
    }

    public static void main(String[] args) {
        test1();

    }
}
