import static org.junit.Assert.*;

import org.junit.Test;


public class TestArrayDequeGold {
    @Test
    public void testOne() {
        ArrayDequeSolution<Integer> deque_gold = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> deque_test = new StudentArrayDeque<>();

        int numTest = 10;
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < numTest; i++) {
            if (StdRandom.uniform() < 0.5) {
                deque_gold.addFirst(i);
                deque_test.addFirst(i);
                s.append("addFirst(").append(i).append(")\n");
            } else {
                deque_gold.addLast(i);
                deque_test.addLast(i);
                s.append("addLast(").append(i).append(")\n");
            }
        }
        for (int i = 0; i < numTest; i++) {
            if (StdRandom.uniform() < 0.5) {
                Integer goldInt = deque_gold.removeFirst();
                Integer testInt = deque_test.removeFirst();
                s.append("removeFirst()\n");
                assertEquals(s.toString(), goldInt, testInt);

            } else {
                Integer goldInt = deque_gold.removeLast();
                Integer testInt = deque_test.removeLast();
                s.append("removeFirst()\n");
                assertEquals(s.toString(), goldInt, testInt);
            }
        }

    }
}
