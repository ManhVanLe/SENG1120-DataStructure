/**
 * TrainCar class represents a train car that can hold cargo and a passenger.
 * It provides methods to load and unload cargo, board and unload passengers.
 * @author Van Manh Le, c3503668
 * @version 1.0 11st May 2025
 * @
 */
public class TrainCar {
    /**
     * The ID of the train car.
     */
    private int carId;
    /**
     * The stack of cargo in the train car.
     */
    private StackADT<Cargo> cargoStack;
    /**
     * The maximum weight limit for cargo in the train car.
     */
    private int cargoWeightLimit;
    /**
     * The passenger currently in the train car.
     */
    private Passenger passenger;
    /**
     * The current weight of the cargo in the train car.
     * This is used to check if the weight limit is exceeded when loading cargo.
     */
    private int weight;

    /**
     * Initialises a TrainCar with a given ID and cargo weight limit.
     * The cargo stack, current weight, and passenger should be initialised appropriately.
     * 
     * @param carId the ID of the train car
     * @param cargoWeightLimit the maximum weight limit for cargo in the car
     */
    public TrainCar(int carId, int cargoWeightLimit) {
        this.carId = carId;
        this.cargoWeightLimit = cargoWeightLimit;
        this.weight = 0;
        this.passenger = null;
        this.cargoStack = new LinkedStack<>();
    }

    /**
     * Loads a cargo into the train car.
     * If the cargo can be loaded without exceeding the weight limit, it is added to the stack and true is returned.
     * Otherwise, the cargo is not added and this method returns false.
     * 
     * @param cargo the cargo to be loaded
     * @return true if the cargo was loaded successfully, false otherwise
     */
    public boolean loadCargo(Cargo cargo) {
        int cargoWeight = cargo.getWeight();
        if ( weight + cargoWeight <= cargoWeightLimit ) {
            cargoStack.push(cargo);
            weight += cargoWeight;
            return true;
        }
        return false;
        
    }

    /**
     * If the cargo is not empty, the top cargo item is removed from the train car and returned.
     * If the cargo is empty, null is returned.
     * 
     * @return the cargo that was unloaded, or null if the cargo is empty
     */
    public Cargo unloadCargo() {
        if (cargoStack.isEmpty()) {
            return null;
        }
        Cargo top = cargoStack.pop();
        weight -= top.getWeight();
        return top;
    }

    /**
     * Checks if the train car has a passenger.
     * 
     * @return true if there is a passenger, false otherwise
     */
    public boolean hasPassenger() {
        return passenger != null;
    }

    /**
     * Boards a passenger into the train car.
     * There can only be one passenger in a train car at a time.
     * If there is already a passenger, a message is printed and the new passenger is not boarded.
     * 
     * @param p the passenger to be boarded
     */
    public void boardPassenger(Passenger p) {
        if (hasPassenger()){
            System.out.println("Train car "+ carId +" already has a passenger, cannot board more passenger.");
        }else{
            this.passenger = p;
        }
    }

    /**
     * Unloads the passenger from the train car.
     * If there is a passenger, they are removed and returned.
     * If there is no passenger, null is returned.
     * 
     * @return the passenger that was unloaded, or null if there was no passenger
     */
    public Passenger unloadPassenger(){
        if(hasPassenger()){
            Passenger hold = passenger;
            passenger = null;
            return hold;
        }
        return null;
    }

    /**
     * Returns the passenger in the train car.
     * If there is no passenger, null is returned.
     * 
     * @return the passenger in the train car, or null if there is none
     */
    public Passenger getPassenger() {
        return passenger;
    }

    /**
     * Returns the ID of the train car.
     * 
     * @return the ID of the train car
     */
    public int getCarId() {
        return carId;
    }

    /**
     * Returns the cargo stack in the train car.
     * @return the cargo stack
     */
    public StackADT<Cargo> getCargoStack() {
        return cargoStack;
    }

    /**
     * This method returns a string representation of the train car.
     * The format should be: "Car <carId> - Passenger: <passenger>, Cargo: <cargo>".
     * 
     * If the car has no passenger, "None" should be displayed for <passenger>.
     * If the cargo stack is empty, "Empty" should be displayed for <cargo>.
     * If the cargo stack is not empty, only the top cargo item should be displayed for <cargo>.
     */
    @Override
    public String toString() {
        return "Car " + carId +
                " - Passenger: " + (passenger != null ? passenger : "None") +
                ", Cargo: " + (cargoStack.isEmpty() ? "Empty" : cargoStack.top());
    }
}
