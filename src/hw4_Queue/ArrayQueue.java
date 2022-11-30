package hw4_Queue;

import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E> {

    private E[] queue;
    private int n = 0;
    private int top = 0;
    private int count = 0;
    private int default_size = 100;

    public ArrayQueue(int capacity) {
        n = capacity;
        queue = (E[]) new Object[capacity];
    }
    public ArrayQueue() {
        n = default_size;
        queue = (E[]) new Object[default_size];
    }
    @Override
    public void enqueue(E element) {
        if (n == default_size)
            throw new IllegalStateException ("Queue is full: Overflow");
        else {
            n++;
            queue[count] = element;
            count = (count+1) % default_size;
        }
    }
    @Override
    public E dequeue() {
        if (n == 0)
            throw new IllegalStateException ("Queue is empty: Underflow");
        else {
            n--;
            E data = queue [ (top % default_size) ];
            queue[top] = null;
            top = (top+1) % default_size;
            return data;
        }
    }

    @Override
    public boolean isEmpty() {
        return n==0;
    }
    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator();
    }

    class ArrayQueueIterator implements Iterator<E> {
        private int current = top;
        private int num = 0;
        @Override
        public boolean hasNext() {
            return num < count;
        }
        @Override
        public E next() {
            E data = queue[(current + num) % n];
            num++;
            return data;
        }
    }
}
