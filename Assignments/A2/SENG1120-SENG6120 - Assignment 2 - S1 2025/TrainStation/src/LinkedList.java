/**
 * Implements a generic doubly linked lst with sentinel head and tail nodes
 * Support access by index, insertion, deletion, interaction, and standard list operations.
 * This custom implementation avoids using java's built-in data structures.
 * 
 * @author Van Manh Le , c3503668
 * @version 1.0 , 11 May 2025
 */
import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedList<E> implements ListADT<E>{
    private Node head;
    private Node tail;
    private int size;
    /**
     * An internal node class, which holds a data item and references to the previous and next nodes in the list.
     */
    private class Node {
        /**
         * The data element.
         */
        E item;

        /**
         * The next node in the list.
         */
        Node next;

        /**
         * The previous node in the list.
         */
        Node prev;

        /**
         * Constructs a new node with the supplied element. 
         * The next and previous nodes are both set to null.
         * 
         * @param element - the element to be placed within the constructed node.
         */
        Node(E element) {
            this.item = element;
            this.prev = null;
            this.next = null;
        }
    }

    public LinkedList(){
        head = new Node(null);
        tail = new Node(null);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    /**
     * Inserts an element at the specified index.
     * Shifting existing elements after the index to the right
     * 
     * @throws IndexOutOfBoundsException if index not in the range
     * @param index - the index that the element is added
     * @param element  - the element to be added to the list
     */
    @Override
    public void add(int index, E element) {
        //Check if the index is within the allowed range
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        //Start from the head sentinel
        Node current = head;
        //Find the node before the given index
        for (int i = 0; i < index; i++){
            current = current.next;
        }
       //The current node is now before the node wanted

       //Insert newNode between current and current.next

        Node nextNode = current.next;//Get the node that will come affter the new node
        Node newNode = new Node(element);//Create a new node with the given element
        //Link newNode between current and nextNode
        newNode.prev = current;   
        newNode.next = nextNode; 
        current.next = newNode;
        nextNode.prev = newNode; 

        size++;//Increase the size of the list
        }
    
    /**
     * Adds an element to the beginning of the list.
     * @param element - the element to be added
     */
    @Override
    public void addFirst(E element) {
        add(0, element);
    }

    /**
     * Adds an element to the end of the list.
     * @param element - the element to be added
     */
    @Override
    public void addLast(E element) {
        add(size, element);
    }

    /**
     * removes all elements from the list by connecting the head and tail to each other, but the list is still usable
     */
    @Override
    public void clear() {
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    /**
     * Return true if the element exists in the list.
     * Uses equals() for comparison, handles null values safely
     * @param element - the element to find
     * @return true if the element exists, false otherwise
     */
    @Override
    public boolean contains(E element) {
        Node current = head.next;
        for (int i = 0; i < size; i++ ){ //Check all the elements
            if (element.equals(current.item) || (element == null && current.item == null ) ){
                return true;//it can handle if the element is null, if the needed element is found, returns true.
            }
            current = current.next;
        }
        return false;//if nothing found, return false
    }

    /**
     * Retrieves the element at the specified index.
     * @throws IndexOutOfBoundsException if index is invalid
     * @return the element at the given index
     */
    @Override
    public E get(int index) {

        if( index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node current = head.next; //Start after the head sentinal
        for (int i = 0; i < index; i++){
            current=current.next; //Move to the desired item
        }
        return current.item; // Return the element data at this index
    }
    /**
     * Returns the first element in the list
     * @throws NoSuchElementException if list is empty
     * @return the first element
     */
    @Override
    public E head() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return get(0);
    }
    /**
     * Returns the last element in the list.
     * @throws NoSuchElementException if list is empty.
     * @return the last elements=
     */
    @Override
    public E tail() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return get(size - 1);
    }
    /** 
     * Return and removes the first element in the list.
     * @throws NoSuchElementException if the list is empty
     * @return the removed element
     */
    @Override
    public E removeFirst() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return remove(0);
    }
    /**
     * Returns and removes the last element in the list
     * @throws NoSuchElementException if list is empty
     * @return the removed element
     */
    @Override
    public E removeLast() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return remove(size - 1);
    }
    /**
     * Removes the element at the specified index and returns it.
     * @throws IllegalStateException if the list is empty
     * @throws IndexOutOfBoundException if index is invalid.
     * @return the removed element
     * @param index - the index of the element to remove
     */
    @Override
    public E remove(int index) {
        //If the list is empty, there's nothing to remove
        if (isEmpty()){
            throw new IllegalStateException();
        }

        //Validate the index
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        //Start from the first real element(after head sentinel)
        Node current = head.next;

        //Move to the node at the specified index
        for (int i = 0; i < index; i++){
            current = current.next;
        }

        //current node now points to the node to be removed
        //store the nodes before and after the one to remove
        Node lhs = current.prev;// node before the one being removed
        Node rhs = current.next;// node after the one being removed

        //link them together - mean the current node is not connected anymore
        lhs.next = rhs;
        rhs.prev = lhs;
        //reduce size by 1
        size--;

        //return the removed element
        return current.item;
    }

    @Override
    /**
     * @return the number of elements in the list
     */
    public int size() {
        return size;
    }
    /**
     * @return true if there is no elements and vice versa
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    /**
     * Private inner class to implement the Iterator interface.
     * 
     */
    private class LinkedListIterator implements Iterator<E>{
        //Pointer to the current node in iteration
        private Node current;

        /**
         * Constructor: initializes the iterator at the first real element (after head setinel)
         */
        public LinkedListIterator(){
            current = head.next; //Star at the first real element
        }
        /**
         * Checks if there are more elements in the list
         * 
         * @return true if the node is not the tail sentiel
         */
        @Override
        public boolean hasNext() {
            return current != tail;//Stop when reaching the tail
        }

        /**
         * Returns the next element in the list and advances the iterator.
         * 
         * @return the current element
         * @throws NoSuchElementException if there are no more elements to return
         */
        @Override
        public E next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }

            E item = current.item;//Store the element to return

            current = current.next;//Move to the next node for future calls

            return item;//Return the element from the previous node
        }

    }
}
