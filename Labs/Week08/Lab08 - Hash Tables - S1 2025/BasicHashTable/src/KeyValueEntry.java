import java.util.Objects;

/**
 * A simple key-value pair entry.
 * The key must be comparable, and entries are compared based on their keys only.
 * 
 * @author Kyle Robert Harrison
 * @version 1.0, 8 Jan 2025
 */
class KeyValueEntry<K extends Comparable<K>, V> implements Comparable<KeyValueEntry<K, V>>{
    /**
     * A unique identifier for the entry
     */
    private K key; 

    /**
     * The value of the entry
     */
    private V value; 

    /**
     * Constructs a new KeyValueEntry with the given key and value.
     * @param key The key of the entry
     * @param value The value of the entry
     */
    public KeyValueEntry(K key, V value){
        this.key = key;
        this.value = value;
    }

    /**
     * Returns the key of the entry.
     * 
     * @return the key stored in the entry
     */
    public K getKey(){
        return key;
    }
    
    /**
     * Returns the value of the entry.
     * 
     * @return the value stored in the entry
     */
    public V getValue(){
        return value;
    }

    /**
     * Checks if two entries are equal, based on their keys. Values are not considered.
     * 
     * {@inheritDoc}
     */
    public boolean equals(Object o){
        if (this == o) return true;

        if (!(o instanceof KeyValueEntry))
            return false;

        @SuppressWarnings("unchecked")
        KeyValueEntry<K,V> e = (KeyValueEntry<K,V>)o;

        return Objects.equals(key, e.key);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode(){
        return key.hashCode();
    }

    /**
     * Compares this KeyValueEntry with another KeyValueEntry, using only the keys.
     * 
     * {@inheritDoc}
     */
    @Override
    public int compareTo(KeyValueEntry<K, V> o) {
        return key.compareTo(o.key);
    }

    @Override
    public String toString() {
        return "(" + key + ": " + value + ")";
    }
}
