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
     * Train object representing the train in the simulation.
     */
    private Train train;
    /**
     * Station object representing the station in the simulation.
     */
    private Station station;

    /**
     * Constructor to initialise the Controller with a new Scanner, Train, and Station.
     */
    public Controller(){
        scanner = new Scanner(System.in);
        train = new Train();
        station = new Station();
    }

    /**
     * Method to run the train simulation.
     * It displays the welcome message and starts the command loop.
     * 
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
                    case 'c': //c [car_id] [cargo_weight_limit]
                        // Create car
                        createCar(command);
                        break;
                    case 'r': //r [car_id]
                        // Remove car
                        removeCar(command);
                        break;
                    case 'l': //l [cargo_id] [desc] [weight] [car_id]
                        // Load cargo into car
                        loadCargo(command);
                        break;
                    case 'p': //p [name] [dest]
                        // Add passenger to station queue
                        addPassenger(command);
                        break;
                    case 'b': //b
                        // Board passengers
                        station.boardPassengers(train);
                        break;
                    case 'u': //u
                        unloadCargo();
                        // Unload cargo from cars
                        break;
                    case 'd': //d
                        departTrain();
                        // Depart train
                        break;
                    case 't': //t
                        train.printTrain();
                        // Print train status
                        break;
                    case 's': //s
                        // Print station passenger queue
                        station.printPassengerQueue();
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
        System.out.println("======================[ Coastal Freight Logistics (CFL) ]=====================");
        System.out.println("                     Welcome to the CFL Station Simulator!");
        System.out.println("==============================================================================");
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
        System.out.println(" c [car_id] [cargo_weight_limit]");
        System.out.println("   Create a new train car with the given ID (int) and cargo weight limit (int).");
        System.out.println(" r [car_id]");
        System.out.println("   Remove a train car with the given ID (int).");
        System.out.println(" l [cargo_id] [desc] [weight] [index]");
        System.out.println("   Load cargo, with the given ID (int), description (desc), and weight (int), into the train car at the given index (int).");
        System.out.println(" p [name]");
        System.out.println("   Add a passenger with the given name (String) to the station queue.");
        System.out.println(" b");
        System.out.println("   Board passengers from the station queue onto the train.");
        System.out.println(" u");
        System.out.println("   Unload cargo from the train cars.");
        System.out.println(" d");
        System.out.println("   Depart the train and unload passengers.");
        System.out.println(" t");
        System.out.println("   Print the train status.");
        System.out.println(" s");
        System.out.println("   Print the station passenger queue.");
        System.out.println(" ?");
        System.out.println("   Show this menu again.");
        System.out.println("==============================================================================");
    }

    /**
     * Create a new train car, given the user command.
     * 
     * tokens[0] = c
     * tokens[1] = [car_id] 
     * tokens[2] = [cargo_weight_limit]
     * 
     * @param command the user command
     * @see #parseCommand(String)
     */
    private void createCar(String command){
        String[] tokens = parseCommand(command);
        if (tokens.length < 3) {
            System.out.println("Invalid command. Usage: c [car_id] [cargo_weight_limit]");
            return;
        }
        int carId = Integer.parseInt(tokens[1]);
        int weightLimit = Integer.parseInt(tokens[2]);
        train.addCar(new TrainCar(carId, weightLimit));
    }

    /**
     * Remove a train car, given the user command.
     * 
     * tokens[0] = c
     * tokens[1] = [car_id] 
     * 
     * @param command the user command
     * @see #parseCommand(String)
     */
    private void removeCar(String command){
        String[] tokens = parseCommand(command);
        if (tokens.length < 2) {
            System.out.println("Invalid command. Usage: r [car_id]");
            return;
        }
        int carId = Integer.parseInt(tokens[1]);
        if(train.removeCar(carId)){
            System.out.println("Car " + carId + " removed successfully.");
        } else {
            System.out.println("Car " + carId + " not found.");
        }
    }

    /**
     * Loads the cargo into the train car, given the user command.
     * 
     * tokens[0] = l
     * tokens[1] = [cargo_id]
     * tokens[2] = [desc]
     * tokens[3] = [weight]
     * tokens[4] = [car_id]
     * 
     * @param command the user command
     * @see #parseCommand(String)
     */
    private void loadCargo(String command){
        String[] tokens = parseCommand(command);
        if (tokens.length < 5) {
            System.out.println("Invalid command. Usage: l [cargo_id] [desc] [weight] [car_id]");
            return;
        }
        int cargoId = Integer.parseInt(tokens[1]);
        String desc = tokens[2];
        int weight = Integer.parseInt(tokens[3]);
        int carId = Integer.parseInt(tokens[4]);

        Cargo cargo = new Cargo(cargoId, desc, weight);
        if (train.getCar(carId).loadCargo(cargo)) {
            System.out.println("Cargo loaded successfully.");
        } else {
            System.out.println("Cargo too heavy.");
        }
    }

    /**
     * Adds a passenger to the station queue, given the user command.
     * 
     * tokens[0] = p
     * tokens[1] = name
     * @param command the user command
     * @see #parseCommand(String)
     */
    private void addPassenger(String command){
        String[] tokens = parseCommand(command);
        if (tokens.length < 2) {
            System.out.println("Invalid command. Usage: p [name]");
            return;
        }
        station.addPassenger(new Passenger(tokens[1]));
    }

    /**
     * Unloads the cargo from the train cars.
     * It iterates through each car and unloads the cargo.
     */
    private void unloadCargo(){
        for (int i = 0; i < train.getSize(); i++) {
            while(!train.getCar(i).getCargoStack().isEmpty()) {
                Cargo unloaded = train.getCar(i).unloadCargo();
                System.out.println("Unloaded from Car " + (i + 1) + ": " + unloaded);
            }
        }
    }

    /**
     * Depart the train and unload passengers.
     * It iterates through each car and unloads the passengers.
     */
    private void departTrain(){
        System.out.println("Train is departing...");
        System.out.println("Train has arrived. Unloading passengers...");
        //unload passengers
        for (int i = 0; i < train.getSize(); i++) {
            Passenger unloaded = train.getCar(i).unloadPassenger();
            if (unloaded != null) {
                System.out.println("Passenger unloaded from Car " + (i + 1) + ": " + unloaded);
            } else {
                System.out.println("Car " + (i + 1) + " is empty.");
            }
        }
    }
}
