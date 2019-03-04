public class LinkedListDeque<T> implements Deque<T> {
    private Node sentinel;
    private int size;

    private class Node {
        private T item;
        private Node next;
        private Node prev;

        public Node(T item0, Node prev0, Node next0) {
            item = item0;
            prev = prev0;
            next = next0;
        }
    }

    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    @Override
    public void addFirst(T item) {
        Node p = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = p;
        sentinel.next = p;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        Node p = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = p;
        sentinel.prev = p;
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void printDeque() {
        Node p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item);
            System.out.print(' ');
            p = p.next;
        }
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node p = sentinel.next;
        sentinel.next = p.next;
        p.next.prev = sentinel;
        size -= 1;
        return p.item;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node p = sentinel.prev;
        sentinel.prev = p.prev;
        p.prev.next = sentinel;
        size -= 1;
        return p.item;
    }

    @Override
    public T get(int index) {
        Node p = sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
            if (p == sentinel) {
                return null;
            }
        }
        return p.item;
    }

    private Node getNodeRecursive(int index) {
        if (index == 0) {
            return sentinel.next;
        }
        return getNodeRecursive(index - 1).next;
    }

    public T getRecursive(int index) {
        return getNodeRecursive(index).item;
    }
}
