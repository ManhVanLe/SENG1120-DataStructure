import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class demonstrates the usage of a hash table implementation.
 * It generates random strings, inserts them into the hash table, checks for their presence,
 * retrieves a specific item, removes some items, and clears the hash table.
 * 
 * @author Kyle Robert Harrison
 * @version 1.0, 24 Apr 2025
 */
public class App {

    static Random random;

    /**
     * Generates a random string of lowercase letters of the specified length.
     * 
     * @param length the length of the string to generate.
     * @return a random string of lowercase letters.
     */
    public static String randomString(int length){
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomChar = (int) (random.nextInt(26)) + 'a';
            sb.append((char) randomChar);
        }

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        random = new Random(0); // use a fixed seed for reproducibility
        int stringLength = 3;
        int numSamples = 20;
        int capacity = 20;

        // Create a list of random strings
        // This is the list of strings that will be used to test the hash table
        List<String> strings = new ArrayList<>(numSamples);
        for (int i = 0; i < numSamples; i++) {
            strings.add(randomString(stringLength));
        }

        // We will use a random string as both the key and value
        // In a real application, the key and value would be different
        // and the key would be used to look up the value
        HashTableADT<String, String> hashTable = new BasicHashTable<>(capacity);
        for (int i = 0; i < numSamples; i++) {
            String s = strings.get(i);
            boolean success = hashTable.insert(s, s);
            if(!success) {
                System.out.println("Collision detected. Failed to insert the key " + s + ".");
            } 
        }

        System.out.println();
        System.out.println("Hash table after insertion");
        System.out.println(hashTable);

        System.out.println();
        System.out.println("Checking contains");
        // Check if the hash table contains the strings
        for (int i = 0; i < numSamples; i++) {
            String s = strings.get(i);
            // Check if the hash table contains the string
            if (!hashTable.contains(s)) {
                System.out.println("Item with key " + s + " not found.");
            }
        }

        
        System.out.println();
        System.out.println("Getting a specific item by key");
        String value = hashTable.get(strings.get(0));
        System.out.println("Value for key " + strings.get(0) + ": " + value);

        System.out.println();
        System.out.println("Removing the first " + numSamples / 2 + " items");
        // Remove the first half of the items
        for (int i = 0; i < numSamples / 2; i++) {
            String s = strings.get(i);
            // Remove the string from the hash table
            hashTable.remove(s);
        }

        System.out.println("Hash table after removal");
        System.out.println(hashTable);

        System.out.println();
        System.out.println("Calling clear");
        // Clear the hash table
        hashTable.clear();

        System.out.println("Hash table after clear");
        System.out.println(hashTable);
    }
    
}
