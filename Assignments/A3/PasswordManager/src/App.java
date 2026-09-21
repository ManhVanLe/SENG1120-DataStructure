/**
 * This is a simple Java application that demonstrates the use of a password manager.
 * It allows users to add, update, delete, and retrieve credentials (username and password) for different sites.
 * The password manager uses a hash table to store the credentials and a binary search tree for ordered traversal.
 * 
 * @author Kyle Robert Harrison
 * @version 1.0, 15 May 2025
 */
public class App {
    public static void main(String[] args) throws Exception {
        Controller controller = new Controller();
        controller.run();
    }
}
