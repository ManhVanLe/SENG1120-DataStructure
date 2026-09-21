/**
 * This class implements a basic hash table using an array of KeyValueEntry objects.
 * There is no collision resolution strategy implemented, so this hash table will not handle collisions.
 * The hash table uses a simple hash function that computes the index based on the hash code of the key.
 * 
 * @param <K> The type of keys in the hash table, which must be comparable to itself.
 * @param <V> The type of values in the hash table.
 * 
 * @author <your name here>
 * @version 1.0, <insert date here>
 */
public class BasicHashTable<K extends Comparable<K>,V> implements HashTableADT<K,V>{

    public BasicHashTable(int capacity) {
        throw new UnsupportedOperationException("Unimplemented constructor 'BasicHashTable'");
    }

    @Override
    public boolean insert(K key, V value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public V remove(K key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public V get(K key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public boolean contains(K key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }
    
}
