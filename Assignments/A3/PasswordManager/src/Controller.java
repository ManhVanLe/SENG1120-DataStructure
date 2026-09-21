import java.util.Scanner;

/**
 * Controller class for the train simulation system.
 * It handles user input and manages the train and station operations.
 * 
 * @author Kyle Robert Harrison
 * @version 1.0, 11 Apr 2025
 */
public class Controller {
    /**
     * Scanner for user input.
     */
    private Scanner scanner;

    /**
     * PasswordManager object for managing passwords.
     */
    private PasswordManager manager;

    /**
     * Constructor to initialise the Controller with a new Scanner and PasswordManager.
     */
    public Controller(){
        scanner = new Scanner(System.in);
        manager = new PasswordManager();
    }

    /**
     * Method to run the simulation.
     * It displays the welcome message and starts the command loop.
     */
    public void run(){
        showWelcome();
       
        do{
            try{
                String command = promptUser();

                switch (command.charAt(0)){
                    case 'q':
                        System.out.println("Goodbye!");
                        System.exit(0);
                        break;
                    case 'a': //a [site] [user] [pass]
                        addCredential(command);
                        break;
                    case 'u': //u [site] [user] [pass]
                        updateCredential(command);
                        break;
                    case 'r': //r [site]
                        removeCredential(command);
                        break;
                    case 'g': //g [site]
                        getCredential(command);
                        break;
                    case 'l': //l
                        manager.listAllCredentials();
                        break;
                    case 's': //s
                        manager.checkAllCredentials();
                        break;
                    case '?': //?
                        // Show the menu of options
                        showMenu();
                        break;
                    default:
                        System.out.println("Invalid command. Please try again.");
                        break;
                }
            }
            catch (Exception e){
                System.out.println("An error occurred: " + e.getMessage());
            }
        } while(true);
    }

    /**
     * Method to prompt the user for input.
     * It displays the menu and waits for user input.
     * 
     * @return the user input as a String
     */
    private String promptUser(){
        System.out.print("Enter command: ");
        String input = scanner.nextLine();
        return input;
    }

    /**
     * Method to parse the user input command.
     * It splits the input string into tokens based on spaces.
     * 
     * @param input the user input command
     * @return an array of tokens
     */
    private String[] parseCommand(String input){
        return input.split(" ");
    }

    /**
     * Method to display the welcome message.
     * It prints the welcome message to the console.
     * 
     */
    private void showWelcome(){
        System.out.println("=======================[ SafeAccount Password Manager ]======================");
        System.out.println("                      Welcome to your SafeAccount vault!");
        System.out.println("=============================================================================");
        showMenu();
    }

    /**
     * Method to display the menu options.
     * It prints the available commands to the console.
     */
    private void showMenu(){
        System.out.println("Commands:");
        System.out.println(" q");
        System.out.println("   Quit the program.");
        System.out.println(" a [site] [user] [pass]");
        System.out.println("   Add a new credential with the given site (String), username (String), and password (String).");
        System.out.println(" u [site] [user] [pass]");
        System.out.println("   Update the credential with the given site (String), if it exists, to the new username (String) and password (String).");
        System.out.println(" r [site]");
        System.out.println("   Remove the credential with the given site (String), if it exists.");
        System.out.println(" g [site]");
        System.out.println("   Get the credential with the given site (String), if it exists.");
        System.out.println(" l");
        System.out.println("   List all credentials.");
        System.out.println(" s");
        System.out.println("   Check the strength of all passwords.");
        System.out.println(" ?");
        System.out.println("   Show this menu again.");
        System.out.println("==============================================================================");
    }

    /**
     * Method to add a new credential.
     * It parses the command and adds the credential to the manager.
     * 
     * @param command the user input command
     */
    private void addCredential(String command){
        String[] tokens = parseCommand(command);
        if (tokens.length != 4) {
            System.out.println("Invalid command. Usage: a [site] [user] [pass]");
            return;
        }

        String site = tokens[1];
        String user = tokens[2];
        String pass = tokens[3];

        boolean status = manager.addCredential(site, user, pass);
        if (status) {
            System.out.println("Credential added.");
        } else {
            System.out.println("Credential already exists. Use updateCredential to change.");
        }
    }
    
    /**
     * Method to update an existing credential.
     * It parses the command and updates the credential in the manager.
     * 
     * @param command the user input command
     */
    private void updateCredential(String command){
        String[] tokens = parseCommand(command);
        if (tokens.length != 4) {
            System.out.println("Invalid command. Usage: u [site] [user] [pass]");
            return;
        }

        String site = tokens[1];
        String user = tokens[2];
        String pass = tokens[3];

        boolean status = manager.updateCredential(site, user, pass);
        if (status) {
            System.out.println("Credential updated.");
        } else {
            System.out.println("Credential not found.");
        }
    }

    /**
     * Method to remove a credential.
     * It parses the command and removes the credential from the manager.
     * 
     * @param command the user input command
     */
    private void removeCredential(String command){
        String[] tokens = parseCommand(command);
        if (tokens.length != 2) {
            System.out.println("Invalid command. Usage: r [site]");
            return;
        }

        String site = tokens[1];

        boolean status = manager.removeCredential(site);
        if (status) {
            System.out.println("Credential removed.");
        } else {
            System.out.println("Credential not found.");
        }
    }

    /**
     * Method to get a credential.
     * It parses the command and retrieves the credential from the manager.
     * 
     * @param command the user input command
     */
    private void getCredential(String command){
        String[] tokens = parseCommand(command);
        if (tokens.length != 2) {
            System.out.println("Invalid command. Usage: g [site]");
            return;
        }

        String site = tokens[1];

        Credential cred = manager.getCredential(site);
        if (cred != null) {
            System.out.println(cred);
        } else {
            System.out.println("Credential not found.");
        }
    }
}
