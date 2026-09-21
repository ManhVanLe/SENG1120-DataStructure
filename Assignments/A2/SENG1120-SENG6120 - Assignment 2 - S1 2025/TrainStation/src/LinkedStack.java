/**
 * Implements a generic LIFO stack susing a custom linked list
 * Supports push, pop, peek, isEmpty, size operation
 * @author Van Manh Le, c3503668
 * @version 1.0 11st May 2025 
 *
 */
import java.util.NoSuchElementException;

public class LinkedStack<E> implements StackADT<E> {
    private LinkedList<E> list;
    /**
     * Construcs an empty stack.
     */
    public LinkedStack(){
        list = new LinkedList<>();
    }

    /**
     * Pushs an element onto the top of the stack.
     * @param element - the element to add
     */
    @Override
    public void push(E element) {
        list.addFirst(element); //Stack is LIFO, so insert at the front
    }

    /** 
     * Removes and returs the top element of the stack.
     * 
     * @return the popped element
     * @throws IllegalStateException if the stack is empty
    */
    @Override
    public E pop() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return list.removeFirst(); //Remove from the front, follow LIFO rule
    }

    /**
     * Returns (not removing) the top element of the stack.
     * 
     * @return the top element
     * @throws IllegalStateException if the stack is empty
     */
    @Override
    public E top() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return list.head();
    }

    /**
     * Check if the stack is empty.
     * 
     * @return True if the stack is empty and vice versa
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
    /**
     * Returns the number of elements in the stack.
     * 
     * @return the size of the stack
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Clear the stack
     */
    @Override
    public void clear() {
        list.clear();
    }
}
