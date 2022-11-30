package hw6_PriorityQueueAndHeap;

public class UnsortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface {
    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public void insert(Entry entry) {
        array[n] = (ArrEntry<K, E>) entry;
        n++;
    }

    @Override
    public void insert(Object o, Object o2) {
        array[n] = new ArrEntry<K, E>((K) o, (E) o2);
        n++;
    }

    @Override
    public Entry removeMin() {
        if (n == 0) {
            return null;
        }
        int min = 0;
        for (int i = 1; i < n; i++) {
            if (array[i].getKey().compareTo(array[min].getKey()) < 0) {
                min = i;
            }
        }
        ArrEntry<K, E> temp = array[min];
        array[min] = array[n - 1];
        array[n - 1] = null;
        n--;
        return temp;
    }

    @Override
    public Entry min() {
        if (n==0) {
            return null;
        } else {
            int min = 0;
            for (int i = 1; i < n; i++) {
                if (array[i].getKey().compareTo(array[min].getKey()) < 0) {
                    min = i;
                }
            }
            return array[min];
        }
    }

    protected class ArrEntry<K, E> implements Entry<K, E> {
        K key;
        E element;

        public ArrEntry(K k, E e) {
            key = k;
            element = e;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public E getValue() {
            return element;
        }
    }

    ArrEntry<K, E>[] array;
    int n = 0;
    int defaultSize = 1000;

    public UnsortedArrayPriorityQueue() {
        array = new ArrEntry[defaultSize];
    }

    public static void main(String[] args) {
        UnsortedArrayPriorityQueue<Integer, String> queue = new UnsortedArrayPriorityQueue<>();
        queue.insert(3, "c");
        queue.insert(1, "a");
        queue.insert(2, "b");
        queue.insert(4, "d");
        queue.insert(5, "e");
        queue.insert(6, "f");

        System.out.println(queue.array[0].getKey());
        System.out.println(queue.array[0].getValue());
    }
}

