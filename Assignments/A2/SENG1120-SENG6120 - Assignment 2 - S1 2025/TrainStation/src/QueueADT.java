/**
 * Interface for a generic queue.
 * 
 * @author Kyle Robert Harrison
 * @version 1.1, 11 Apr 2025 - updated to extend Iterable
 * @version 1.0, 8 Jan 2025
 */
public interface QueueADT<E> extends Iterable<E> {
    /**
     * Adds an element to the end of the queue.
     * @param element the element to be added
     */
    public void enqueue(E element);

    /**
     * Removes and returns the front element of the queue.
     * @return the front element
     */
    public E dequeue();
    /**
     * Returns the front element of the queue without removing it.
     * @return the front element
     */
    public E front();

    /**
     * Checks if the queue is empty.
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty();
    
    /**
     * Returns the number of elements in the queue.
     * @return the size of the queue
     */
    public int size();

    /**
     * Removes all elements from the queue, leaving it in an empty, but usable, state.
     */
    public void clear();
}
