/**
 * Cargo class represents a cargo item with an ID, description, and weight.
 * 
 * @author Kyle Robert Harrison
 * @version 1.0, 11 Apr 2025
 */
public class Cargo {
    /**
     * The ID of the cargo item.
     */
    private int id;
    /**
     * A description of the cargo item.
     */
    private String description;
    /**
     * The weight of the cargo item.
     */
    private int weight;

    /**
     * Initialises the cargo item with an ID, description, and weight.
     * 
     * @param id The ID of the cargo item
     * @param description A description of the cargo item
     * @param weight The weight of the cargo item
     */
    public Cargo(int id, String description, int weight) {
        this.id = id;
        this.description = description;
        this.weight = weight;
    }

    /**
     * Gets the ID of the cargo item.
     * 
     * @return The ID of the cargo item
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the description of the cargo item.
     * 
     * @return The description of the cargo
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the weight of the cargo item.
     * 
     * @return The weight of the cargo
     */
    public int getWeight(){
        return weight;
    }

    /**
     * Returns a string representation of the cargo item.
     * The format is "Cargo[<ID> - <description> - <weight>]".
     */
    @Override
    public String toString() {
        return "Cargo[" + id + " - " + description +  " - " + weight + "]";
    }
}
