package hw6_PriorityQueueAndHeap;

import java.util.StringJoiner;

public class SortedArrayPriorityQueue <K extends Comparable, E> implements PriorityQueueInterface {

    @Override
    public int size() {  // check the size of the array
        return n;
    }

    @Override
    public boolean isEmpty() {  //checks if the array is empty
        return n == 0;
    }

    @Override
    public void insert(Entry entry) {   //inserts an entry into the array
        if(n==0) {
            array[n] = (ArrEntry<K, E>) entry;
        }
        else {
            int i = n-1;
            while (i>=0 && array[i].getKey().compareTo(entry.getKey()) > 0) {
                array[i+1] = array[i];
                i--;
            }
            array[i+1] = (ArrEntry<K, E>) entry;
        }
        n++;
    }

    @Override
    public void insert(Object o, Object o2) { //inserts an object into the array
        if(n==0) {
            array[n] = new ArrEntry<K, E>((K) o, (E) o2);
        }
        else {
            int i = n-1;
            while (i>=0 && array[i].getKey().compareTo((K) o) > 0) {
                array[i+1] = array[i];
                i--;
            }
            array[i+1] = new ArrEntry<K, E>((K) o, (E) o2);
        }
        n++;
    }

    @Override
    public Entry removeMin() { //removes the minimum entry from the array
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
    public Entry min() { //finds the minimum entry in the array
        Entry min = array[0];
        for (int i = 0; i < n; i++) {
            if (array[i].getKey().compareTo(min.getKey()) < 0) {
                min = array[i];
            }
        }
        return min;
    }

    protected class ArrEntry<K, E> implements Entry<K, E>{
        K key;
        E element;
        public ArrEntry (K k, E e){
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
    ArrEntry<K, E> [] array;
    int n = 0;
    int defaultSize = 1000;

    public SortedArrayPriorityQueue(){
        array = new ArrEntry[defaultSize];
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < n; i++) {
            sj.add(array[i].getKey().toString() + " " + array[i].getValue().toString());
        }
        return sj.toString();
    }

    public static void main(String[] args) {
        SortedArrayPriorityQueue<Integer, String> sortedArrayPriorityQueue = new SortedArrayPriorityQueue<>();
        sortedArrayPriorityQueue.insert(2, "b");
        sortedArrayPriorityQueue.insert(4, "d");
        sortedArrayPriorityQueue.insert(3, "c");
        sortedArrayPriorityQueue.insert(1, "a");
        sortedArrayPriorityQueue.insert(5, "e");


        System.out.println("Size of the array is: " + sortedArrayPriorityQueue.size());
        System.out.println(sortedArrayPriorityQueue);
    }
}
