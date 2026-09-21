/**
 * Implements a generic FIFO queue using a custom linked list.
 * Support enqueue, dequeue, peek, clear, and iteration
 * @author Van Manh Le, c3503668
 * @version 1.0 11st May 2025
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<E> implements QueueADT<E> {
    //Interal linked list to store queue elements
    private LinkedList<E> list;

    //Constructs an epty queue
    public LinkedQueue(){
        list = new LinkedList<>();
    }
    /**
     * Adds an element to the rear of the queue.
     * @param element - the element to be enqueued
     */
    @Override
    public void enqueue(E element) {
        list.addLast(element); //Add to end
    }

    /**
     * @return the front element
     * @throws NoSuchElementException if the queue is empty
     */
    @Override
    public E dequeue() {
        if (isEmpty()){ 
            throw new NoSuchElementException();
        }
        return list.removeFirst(); // Remove from front 
    }
    /**
     * return (not removing) the front element of the queue
     * @return the front element
     * @throws NoSuchElementException if the queue is empty
     */
    @Override
    public E front() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return list.head(); //Get the front element (index 0)
    }
    /**
     * Checks whether the queue is empty
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Return the number of elements in the queue
     * @return the size of the queue
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Remove all elements from the queue.
     */
    @Override
    public void clear() {
        list.clear();
    }

    /**
     * Returns an iterator over the elements in this queue.
     * @return an iterator for the queue
     */
    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
}
