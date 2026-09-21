/**
 * This interface represents a hash table with a generic key type K
 * and generic value type V. The key type must be comparable to itself
 * (i.e., K must implement Comparable<K>).
 * 
 * @author Kyle Robert Harrison
 * @version 1.0, 8 Jan 2025
 */
public interface HashTableADT<K extends Comparable<K>, V> {
    /**
     * Insert a key-value pair into the hash table. If the key already exists, update the value.
     * An updated entry should not increase the size of the hash table.
     * 
     * @param key The key value associated with the item.
     * @param value The value associated with the item.
     * @return true if the insertion (or update) was successful, false otherwise.
     */
    public boolean insert(K key, V value);

    /**
     * Remove the item with the specified key from the hash table, if it exists. 
     * 
     * @param key The key for the item to be removed.
     * @return The item that was removed, or null if no item is removed.
     */
    public V remove(K key);

    /**
     * Retrieve (without removing) the item with the specific key from the hash table, if it exists.
     * 
     * @param key The key for the item to be retrieved.
     * @return The item that was retrieved, or null if no item with the specified key was found.
     */
    public V get(K key);

    /**
     * Determine if an item with the specified key exists.
     * 
     * @param key The key for the item to be checked for existence.
     * @return true if an item with the specified key exists, false otherwise.
     */
    public boolean contains(K key);

    /**
     * Returns true if this hash table is empty (i.e., contains no elements).

     * @return true if this hash table is empty, false otherwise.
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in this hash table.
     * 
     * @return the number of elements in this hash table.
     */
    public int size();

    /**
     * Removes all of the elements from this hash table, leaving it in a usable, empty state.
     */
    public void clear();
}
