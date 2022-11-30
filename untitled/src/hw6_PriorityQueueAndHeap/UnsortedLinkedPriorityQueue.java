package hw6_PriorityQueueAndHeap;

import java.util.StringJoiner;

public class UnsortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface {
    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public void insert(Entry entry) { //inserts an entry into the priority queue
        NodeEntry<K, E> temp = new NodeEntry<K, E>((K)entry.getKey(), (E)entry.getValue());
        if (n == 0) {
            head = temp;
        } else {
            tail.next = temp;
        }
        tail = temp;
        n++;
    }

    @Override
    public void insert(Object o, Object o2) {
        NodeEntry<K, E> temp = new NodeEntry<K, E>((K)o, (E)o2);
        if (n == 0) {
            head = temp;
        } else {
            tail.next = temp;
        }
        tail = temp;
        n++;
    }

    @Override
    public Entry removeMin() {
        if (n==0) {
            return null;
        }
        else {
            NodeEntry<K, E> min = head;
            NodeEntry<K, E> minPrev = null;
            NodeEntry<K, E> prev = null;
            NodeEntry<K, E> curr = head;
            while (curr != null) {
                if (curr.getKey().compareTo(min.getKey()) < 0) {
                    min = curr;
                    minPrev = prev;
                }
                prev = curr;
                curr = curr.next;
            }
            if (minPrev == null) {
                head = head.next;
            } else {
                minPrev.next = min.next;
            }
            n--;
            return min;
        }
    }

    @Override
    public Entry min() {
        if (n==0) {
            return null;
        }
        else {
            NodeEntry<K, E> min = head;
            NodeEntry<K, E> temp = head;
            while (temp != null) {
                if (temp.getKey().compareTo(min.getKey()) < 0) {
                    min = temp;
                }
                temp = temp.next;
            }
            return min;
        }
    }

    protected class NodeEntry<K, E> implements Entry<K, E>{
        private K key;
        private E element;
        private NodeEntry<K, E> next;

        public NodeEntry (K k, E e){
            key = k;
            element = e;
            next = null;
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
    private NodeEntry<K,E> head;
    private NodeEntry<K,E> tail;
    int n = 0;

    public UnsortedLinkedPriorityQueue() {
        head = null;
        tail = null;
        n = 0;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        NodeEntry<K, E> temp = head;
        while (temp != null) {
            sj.add(temp.getKey().toString()+" "+temp.getValue().toString());
            temp = temp.next;
        }
        return sj.toString();
    }

    public static void main(String[] args) {
        UnsortedLinkedPriorityQueue<Integer, String> un = new UnsortedLinkedPriorityQueue<>();
        un.insert(3, "c");
        un.insert(1, "a");
        un.insert(4, "d");
        un.insert(2, "b");

        System.out.println("Min : "+un.min().getKey());
        System.out.println(un);
    }
}
