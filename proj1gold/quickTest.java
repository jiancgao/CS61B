
public class quickTest {
    public static void main(String[] args){
        ArrayDequeSolution<Integer> deque_gold = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> deque_test = new StudentArrayDeque<>();
        deque_test.addFirst(0);
        deque_test.addFirst(1);
        deque_test.addFirst(2);
        deque_test.addFirst(3);
        deque_test.addLast(4);
        deque_test.addLast(5);
        deque_test.addLast(6);
        deque_test.addLast(7);
        deque_test.addLast(8);
        deque_test.addFirst(9);
        int num;
        num=deque_test.removeFirst();
        num=deque_test.removeFirst();
        num=deque_test.removeFirst();
        num=deque_test.removeFirst();
    }

}
