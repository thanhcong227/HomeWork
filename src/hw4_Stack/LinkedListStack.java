package hw4_Stack;

import java.util.EmptyStackException;
import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface {

    class Node {
        E element;
        Node next;
    }

    private Node stack = null;

    @Override
    public void push(Object element) {
        Node oldStack = stack;
        stack = new Node();
        stack.element = (E) element;
        stack.next = oldStack;
    }

    @Override
    public Object pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E element = stack.element;
        stack = stack.next;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return stack==null;
    }

    @Override
    public Object top() {
        if(isEmpty()) {
            System.out.println("The stack is empty");
        }
        return stack.element;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }


    class StackIterator implements Iterator<E> {
        private Node currentNode = stack;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }
        @Override
        public E next() {
            E data = currentNode.element;
            currentNode = currentNode.next;
            return data;
        }
    }

}
