package hw6_PriorityQueueAndHeap;

import java.util.StringJoiner;

public class SortedLinkedPriorityQueue <K extends Comparable, E> implements PriorityQueueInterface {
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
        if(n==0){
            head = new NodeEntry<K, E>((K)entry.getKey(), (E)entry.getValue());
            tail = head;
        }
        else{
            NodeEntry<K, E> temp = new NodeEntry<K, E>((K)entry.getKey(), (E)entry.getValue());
            if(temp.getKey().compareTo(head.getKey())<0){
                temp.next = head;
                head = temp;
            }
            else if(temp.getKey().compareTo(tail.getKey())>0){
                tail.next = temp;
                tail = temp;
            }
            else{
                NodeEntry<K, E> prev = head;
                NodeEntry<K, E> curr = head.next;
                while(curr!=null){
                    if(temp.getKey().compareTo(curr.getKey())<0){
                        prev.next = temp;
                        temp.next = curr;
                        break;
                    }
                    prev = curr;
                    curr = curr.next;
                }
            }
        }
        n++;
    }

    @Override
    public void insert(Object o, Object o2) {
        if(n==0){
            head = new NodeEntry<K, E>((K)o, (E)o2);
            tail = head;
        }
        else{
            NodeEntry<K, E> temp = new NodeEntry<K, E>((K)o, (E)o2);
            if(temp.getKey().compareTo(head.getKey())<0){
                temp.next = head;
                head = temp;
            }
            else if(temp.getKey().compareTo(tail.getKey())>0){
                tail.next = temp;
                tail = temp;
            }
            else{
                NodeEntry<K, E> prev = head;
                NodeEntry<K, E> curr = head.next;
                while(curr!=null){
                    if(temp.getKey().compareTo(curr.getKey())<0){
                        prev.next = temp;
                        temp.next = curr;
                        break;
                    }
                    prev = curr;
                    curr = curr.next;
                }
            }
        }
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
            NodeEntry<K, E> curr = head;
            while (curr != null) {
                if (curr.getKey().compareTo(min.getKey()) < 0) {
                    min = curr;
                }
                curr = curr.next;
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
        SortedLinkedPriorityQueue<Integer, String> queue = new SortedLinkedPriorityQueue<>();
        queue.insert(4, "d");
        queue.insert(1, "a");
        queue.insert(5, "e");
        queue.insert(2, "b");
        queue.insert(3, "c");
        System.out.println(queue);
        System.out.println("Size : "+queue.size());

    }
}
