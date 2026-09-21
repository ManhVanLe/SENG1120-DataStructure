/**
 * A class to manage user credentials for different sites.
 * It allows adding, updating, retrieving, listing, checking password strength,
 * and removing credentials.
 * 
 * This class uses a hash table and a binary search tree to store the credentials.
 * The hash table is used for fast access to credentials by site name (which is the key of the entries),
 * while the binary search tree is used for ordered traversal of credentials (also using the site name as the key).
 * 
 * @author Van Manh Le c3503668
 * @version 1.0 31/05/2025
 */
public class PasswordManager {
    private HashTableADT<String, Credential> hashTable;
    private BinarySearchTreeADT<String, Credential> bst;

    public PasswordManager() {
        // Initialize the hash table for fast access and BST for ordered listing
        hashTable = new ChainingHashTable<>();
        bst = new LinkedBinarySearchTree<>();

    }
    /**
     * Adds a new credential to the password manager. 
     * The credential consists of a site, username, and password.
     * The credential is stored in both a hash table and a binary search tree.
     * If the site already exists, it will not be added.
     * 
     * @param site the name of the site
     * @param username the username for the site
     * @param password the password for the site
     * 
     * @return true if the credential was added successfully, false if the site already exists or otherwise fails to insert
     */
    public boolean addCredential(String site, String username, String password) {
        if (hashTable.contains(site)) {
            return false;// Do not add duplicate site entries
        }
        Credential credential = new Credential(site, username, password);
        boolean hashInserted = hashTable.insert(site, credential);// insert into hash table
        bst.insert(site,credential);// Also insert into BST for ordering
        return hashInserted;
    }

    /**
     * Updates an existing credential in the password manager.
     * The credential consists of a site, username, and password.
     * The credential is updated in both the hash table and the binary search tree.
     * 
     * @param site the name of the site
     * @param newUsername the new username for the site
     * @param newPassword the new password for the site
     * @return true if the credential was updated successfully, false if the site does not exist
     */
    public boolean updateCredential(String site, String newUsername, String newPassword) {
        if (!hashTable.contains(site)) {
            return false; //Can not update if site doesnt exist
        }
        Credential credential = hashTable.get(site);
        credential.setUsername(newUsername);
        credential.setPassword(newPassword);
        // Update in both structures (remove + re-insert to keep BST consistent)
        bst.remove(site);
        bst.insert(site, credential);
        return true;
    }


    /**
     * Retrieves a credential from the password manager by site name.
     * This should retrieve the credential from the hash table.
     * 
     * @param site the name of the site
     * @return the credential for the site, or null if it does not exist
     */
    public Credential getCredential(String site) {
        return hashTable.get(site);
    }

        /**
     * Removes a credential from the password manager by site name.
     * The credential is removed from both the hash table and the binary search tree.
     * 
     * @param site the name of the site
     * @return true if the credential was removed successfully, false if the site does not exist
     */
    public boolean removeCredential(String site) {
        if (!hashTable.contains(site)){
            return false;// Nothing to remove if site isnt stored
        }
        hashTable.remove(site);//Remove from hash table
        bst.remove(site);//Remove from BST
        return true;
    }

    /**
     * Lists all credentials in the password manager.
     * The credentials are printed in order of their site names.
     * This method uses the binary search tree for ordered traversal, specifically in-order traversal using the iterator.
     * 
     * Results are printed one per line, and should be printed using the string representation of the Credential object.
     */
    public void listAllCredentials() {
        for (Credential cred : bst) {
            System.out.println(cred);
        }
    }

    /**
     * Checks the strength of all passwords in the password manager.
     * The strength is evaluated using the PasswordStrengthChecker class.
     * The results are printed to the console.
     * 
     * Results are printed in order of their site names, and should be printed as follows:
     * <Credential>, Password strength: <strength>
     * where <Credential> is the string representation of the Credential object, and <strength> is the strength of the password.
     */
    public void checkAllCredentials() {
        for (Credential cred : bst){
            String strength = PasswordStrengthChecker.evaluate(cred.getPassword());
            System.out.println("[" +cred.getSite() + "] Password Strength: "+ strength);
        }
    }
}