public class ArrayDeque<T> {

    private T[] array;
    private int size;
    private int length;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        length = 8;
        array = (T[]) new Object[length];
        size = 0;
        nextFirst = 0;
        nextLast = 1;

    }

    private void checkSize() {
        double ratio = (double) size / (double) length;
        if (ratio > 0.75) {
            resize(length * 2);
        }
        if (ratio <= 0.25 && length >= 16) {
            resize(length / 2);
        }
    }

    private void resize(int newLength) {
        T[] newArray = (T[]) new Object[newLength];
        int index = adjustIndex(nextFirst + 1);
        int num = 0;
        for (; num < size; num++) {
            newArray[num + 1] = array[index];
            index = adjustIndex(index + 1);
        }
        nextFirst = 0;
        nextLast = size + 1;
//        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
        length = newLength;
    }

    public int adjustIndex(int i) {
        while (i < 0) {
            i += length;
        }
        i = i % length;
        return i;
    }

    public void addFirst(T item) {
        array[nextFirst] = item;
        size += 1;
        nextFirst = adjustIndex(nextFirst - 1);
        checkSize();
    }

    public void addLast(T item) {
        array[nextLast] = item;
        size += 1;
        nextLast = adjustIndex(nextLast + 1);
        checkSize();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        int index = adjustIndex(nextFirst + 1);
        for (int num = 0; num < size; num++) {
            System.out.print(array[index]);
            System.out.print(' ');
            index = adjustIndex(index + 1);
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        nextFirst = adjustIndex(nextFirst + 1);
        T item = array[nextFirst];
        array[nextFirst] = null;
        size -= 1;
        checkSize();
        return item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        nextLast = adjustIndex(nextLast - 1);
        T item = array[nextLast];
        array[nextLast] = null;
        size -= 1;
        checkSize();
        return item;
    }

    public T get(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        index = adjustIndex(nextFirst + 1 + index);
        return array[index];
    }


}
