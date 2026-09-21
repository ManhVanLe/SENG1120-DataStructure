/**
 * A demonstration of the Vehicle Rental Service.
 * This class contains only some basic operations to demonstrate the functionality of the Vehicle Rental Service.
 * You are encouraged to add more operations to further test the Vehicle Rental Service.
 * Similarly, you should add unit tests to ensure that the Vehicle Rental Service (and other classes) work as expected.
 * 
 * @author Kyle Robert Harrison
 * @version 1.0, 13 March 2025
 */
public class App {
    public static void main(String[] args) throws Exception {
        // Create a new VehicleRentalService with a capacity of 10
        VehicleRentalService service = new VehicleRentalService(10);

        // Create a car and a motorcycle, with different daily rates
        Vehicle car = new Car("Toyota", 50);
        Vehicle bike = new Motorcycle("Harley", 20);

        // Add the vehicles to the rental service
        service.addVehicle(car);
        service.addVehicle(bike);

        // Use the iterator to print the available vehicles
        System.out.println("*** Available Vehicles ***");
        for (Vehicle vehicle : service) {
            System.out.println(vehicle);
        }

        // Perform some rental operations
        System.out.println("\n*** Renting Vehicles ***");
        
        // Rent the first vehicle (car) with Basic insurance for 10 days
        service.rentVehicle(0); // Rent the car
        InsurancePlan basicInsurance = new BasicInsurance();
        System.out.println("Rental cost for " + service.getModel(0) + " 10 days with Basic insurance: $" + service.calculateRentalCost(0, 10, basicInsurance));

        // Attempt to rent the first vehicle (car) again, but it is already rented
        service.rentVehicle(0); // Rent the car again

        // Rent the first available vehicle (motorcycle) with Premium insurance for 5 days
        System.out.println("\nSearching for available vehicles ...");
        int firstAvailable = service.firstAvailable();
        if (firstAvailable != -1) {
            service.rentVehicle(firstAvailable);
            InsurancePlan premiumInsurance = new PremiumInsurance();
            System.out.println("Rental cost for " + service.getModel(firstAvailable) + " 5 days with Premium insurance: $" + service.calculateRentalCost(firstAvailable, 5, premiumInsurance));
        } else {
            System.out.println("No vehicles available!");
        }

        // Try to rent another vehicle, but there are no vehicles available
        System.out.println("Searching for available vehicles ...");
        int nextAvailable = service.firstAvailable();
        if (nextAvailable != -1) {
            service.rentVehicle(nextAvailable);
            InsurancePlan premiumInsurance = new PremiumInsurance();
            System.out.println("Rental cost for " + service.getModel(nextAvailable) + " 5 days with Premium insurance: $" + service.calculateRentalCost(nextAvailable, 5, premiumInsurance));
        } else {
            System.out.println("No vehicles available!");
        }

        // Return the vehicles
        System.out.println("\n*** Returning Vehicles ***");
        service.returnVehicle(0); // Return the car
        service.returnVehicle(firstAvailable); // Return the car
    }
}
