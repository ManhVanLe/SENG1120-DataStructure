/**
 * Interface for a generic stack.
 * 
 * @author Kyle Robert Harrison
 * @version 1.0, 8 Jan 2025
 */
public interface StackADT<E> {
    /**
     * Pushes an element onto the stack.
     * @param element the element to be pushed
     */
    public void push(E element);
    /**
     * Pops an element from the stack.
     * @return the popped element
     */
    public E pop();
    /**
     * Peeks at the top element of the stack without removing it.
     * @return the top element
     */
    public E top();
    
    /**
     * Checks if the stack is empty.
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty();
    
    /**
     * Returns the number of elements in the stack.
     * @return the size of the stack
     */
    public int size();

    /**
     * Removes all elements from the stack, leaving it in an empty, but usable, state.
     */
    public void clear();
}
