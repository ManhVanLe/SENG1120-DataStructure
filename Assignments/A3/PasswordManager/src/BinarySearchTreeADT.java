import java.util.Iterator;

/**
 * An interface for a binary search tree (BST) data structure.
 * 
 * @author Kyle Robert Harrison
 * @version 1.0, 8 Jan 2025
 */
public interface BinarySearchTreeADT<K extends Comparable<K>, V> extends Iterable<V> {

    /**
     * Inserts a new key-value pair into the tree.
     * If the key already exists, the value is updated.
     * An updated entry should not increase the size of the tree.
     * @param key the key to insert
     * @param value the value to insert
     */
    public void insert(K key, V value);

    /**
     * Removes the key-value pair with the specified key from the tree.
     * If the key does not exist, this does nothing.
     * @param key the key to remove
     */
    public void remove(K key);

    /**
     * Checks if the tree contains a key.
     * @param key the key to check
     * @return true if the key exists, false otherwise
     */
    public boolean contains(K key);

    /**
     * Finds the value associated with the specified key.
     * This should return null if the key is not found.
     * @param key the key to find.
     * @return the value associated with the key, or null if not found
     */
    public V find(K key);

    /**
     * Finds the value associated with the minimum key in the tree.
     * This should return null if the tree is empty.
     * @return the minimum value, or null if the tree is empty.
     */
    public V findMin();

    /**
     * Finds the value associated with the maximum key in the tree.
     * This should return null if the tree is empty.
     * @return the maximum value, or null if the tree is empty.
     */
    public V findMax();

    /**
     * Returns an iterator for the tree in inorder traversal.
     * This should be the default iterator for the tree, which is used when the 
     * tree is iterated over.
     * @return an iterator for the tree
     */
    public Iterator<V> inorderIterator();
    /**
     * Returns an iterator for the tree in preorder traversal.
     * @return an iterator for the tree
     */
    public Iterator<V> preorderIterator();
    /**
     * Returns an iterator for the tree in postorder traversal.
     * @return an iterator for the tree
     */
    public Iterator<V> postorderIterator();

    /**
     * Checks if the tree is empty.
     * @return true if the tree is empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in the tree.
     * @return the size of the tree
     */
    public int size();

    /**
     * Clears the tree, removing all elements.
     */
    public void clear();
}
