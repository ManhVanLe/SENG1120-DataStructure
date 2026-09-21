import java.util.LinkedList;

/**
 * Implementation of a hash table using linked list chaining for collision resolution.
 * This implementation uses a linked list to store the entries in each cell of the hash table.
 * You should use the LinkedList class from the Java Collections Framework (i.e., java.util.LinkedList) for the implementation.
 * 
 * You should use the KeyValueEntry class to store the key-value pairs.
 * The hash table uses the (existing) hashCode() method of the key to determine the index in the table.
 * Note: the hashCode() method may return negative values, so you should use Math.abs() to ensure the index is non-negative.
 * 
 * @author Van Manh Le c3503668
 * @version 1.0 , 31/05/2025
 */
public class ChainingHashTable<K extends Comparable<K>,V> implements HashTableADT<K,V> {
    // The array of LinkedLists to store key-value pairs
    private LinkedList<KeyValueEntry<K, V>>[] table;

    // Number of key-value pairs currently stored in the table
    private int size;

    // Default number of cells in the hash table
    private static final int DEFAULT_CAPACITY = 11;

    // Constructs a hash table with the default capacity
    @SuppressWarnings("unchecked")
    public ChainingHashTable() {
        table = new LinkedList[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Construct a hash table with a specified number of cells.
     * 
     * @param numCells - the number of cells in the hash table
     */
    @SuppressWarnings("unchecked")
    public ChainingHashTable(int numCells){
        table = new LinkedList[numCells];
        size = 0;
    }

    /**
     * Computes the index for a given key in the hash table.
     * 
     * @param key - the key to compute the index for
     * @return the non-negative index within the bounds of the table
     */
    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    /**
     * Inserts a key-value pair into the hash table.
     * 
     * @param key - the key to insert
     * @param value - the value to insert
     * @return true if the insertion is successful, false otherwise
     */
    @Override
    public boolean insert(K key, V value) {
        int index = getIndex(key);

        //Create a new linked list at this bucket if it does not exist
        if (table[index]==null) {
            table[index] = new LinkedList<>();
        }

        KeyValueEntry<K, V> entry = new KeyValueEntry<>(key, value);

        // Check for duplicate key
        int pos = table[index].indexOf(entry);
        if (pos != -1){
            return false;
        }

        //Add entry to the chaining list
        table[index].add(entry);
        size++;
        return true;
    }

    /**
     * Removes a key-value pair from the hash table.
     * 
     * @param key - the key to remove
     * @return the value associated with the key, or null if the key is not found
     */
    @Override
    public V remove(K key) {
        int index = getIndex(key);
        if (table[index] == null) 
            return null;// no chain at this index

        KeyValueEntry<K, V> dummy = new KeyValueEntry<>(key,null);
        int pos = table[index].indexOf(dummy);
        if (pos == -1)
            return null;//key not found

        V value = table[index].get(pos).getValue();
        table[index].remove(pos); //remove from chain
        size--;
        return value;
    }
    /**
     * Returns the value associated with a given key.
     * 
     * @param key - the key to retrieve the value for
     * @return the value associated with the key, or null if the key is not found
     */
    @Override
    public V get(K key) {
        int index = getIndex(key);
        if (table[index] == null)
            return null;

        KeyValueEntry<K, V> dummy = new KeyValueEntry<>(key, null);
        int pos = table[index].indexOf(dummy);
        if (pos == -1)
            return null;//key not found

        return table[index].get(pos).getValue();
    }

    /**
     * Checks if the hash table contains a given key.
     * 
     * @param key - the key to check for
     * @return true if the key is found, false otherwise
     */
    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    /**
     * Checks if the hash table is empty.
     * 
     * @return true if the hash table is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of key-value pairs currently stored in the hash table.
     * 
     * @return the number of key-value pairs in the hash table
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all key-value pairs from the hash table and resets the size to 0.
     */
    @Override
    public void clear() {
        for (int i = 0; i < table.length; i++){
            if (table[i] != null) {
                table[i].clear();//clear the individual chain
            }
        }
        size = 0; //reset the size
    }
}
