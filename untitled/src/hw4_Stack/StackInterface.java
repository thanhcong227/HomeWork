package hw4_Stack;

public interface StackInterface<E> extends Iterable<E> {
    public void push(E elenment);
    public E pop();
    public boolean isEmpty();
    public E top();
}
