/**
 * An abstract class representing a vehicle.
 * This class is the parent class of Car and Motorcycle.
 * 
 * @author Kyle Robert Harrison
 * @version 1.0, 13 March 2025
 */
public abstract class Vehicle {
    /**
     * The model of the vehicle.
     * It is marked as protected so that it can be accessed by subclasses.
     */
    protected String model;

    /**
     * The daily rental rate of the vehicle.
     * It is marked as protected so that it can be accessed by subclasses.
     */
    protected double dailyRate;

    /**
     * A boolean indicating whether the vehicle is rented.
     * It is marked as protected so that it can be accessed by subclasses.
     */
    protected boolean isRented;

    /**
     * Constructs a new Vehicle object with the given model and daily rate.
     * The vehicle is not rented by default.
     * 
     * @param model The model of the vehicle
     * @param dailyRate The daily rental rate of the vehicle
     */
    public Vehicle(String model, double dailyRate) {
        this.model = model;
        this.dailyRate = dailyRate;
        this.isRented = false;
    }

    /**
     * Returns the model of the vehicle.
     * 
     * @return The model of the vehicle
     */
    public String getModel() {
        return model;
    }

    /**
     * Rents the vehicle.
     * If the vehicle is already rented, a message is printed to the console.
     * If the vehicle is not rented, the vehicle is marked as rented and a message is printed to the console.
     */
    public void rent() {
        if (!isRented) {
            isRented = true;
            System.out.println(getType() + " rented: " + model);
        } else {
            System.out.println(getType() + " is already rented: " + model);
        }
    }

    /**
     * Returns the vehicle.
     * If the vehicle is rented, the vehicle is marked as not rented and a message is printed to the console.
     * If the vehicle is not rented, a message is printed to the console.
     */
    public void returnVehicle() {
        if (isRented) {
            isRented = false;
            System.out.println(getType() + " returned: " + model);
        } else {
            System.out.println(getType() + " was not rented: " + model);
        }
    }


    /**
     * Returns a string representation of the vehicle.
     * The string representation includes the type of vehicle, the model of the vehicle, and the daily rental rate of the vehicle.
     */
    @Override
    public String toString() {
        return getType() + " Model: " + model + ", Daily Rate: $" + dailyRate;
    }

    /**
     * Calculates the cost of renting the vehicle for the given number of days with the given insurance plan.
     * 
     * @param days The number of days to rent the vehicle
     * @param insurancePlan The insurance plan to use
     * @return The cost of renting the vehicle for the given number of days with the given insurance plan
     */
    protected abstract double calculateRentalCost(int days, InsurancePlan insurancePlan);

    /**
     * Returns the type of the vehicle.
     * 
     * @return The type of the vehicle
     */
    protected abstract String getType();

}