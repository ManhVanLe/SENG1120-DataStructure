/**
 * Passenger class representing a passenger in a train reservation system.
 * 
 * @author Kyle Robert Harrison
 * @version 1.0, 11 Apr 2025
 */
public class Passenger {
    /**
     * The name of the passenger.
     */
    private String name;

    /**
     * Constructor to create a new Passenger with the given name.
     * 
     * @param name the name of the passenger
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the passenger.
     * 
     * @return the name of the passenger
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a string representation of the passenger, which is the name of the passenger.
     * 
     * @return the name of the passenger as the string representation
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return name;
    }
}
