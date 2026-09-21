/**
 * The main method implementation are in this class
 * @author Manh Van Le c3503668
 * @version 1.0, 4 April 2025
*/
import java.util.Iterator;
import java.util.NoSuchElementException;

public class VehicleRentalService implements Iterable<Vehicle>{
    Vehicle[] service;
    int numVehicles, totalCapa;
    public VehicleRentalService(int capacity) {
        service = new Vehicle[capacity];
        numVehicles = 0 ;
        totalCapa = capacity;
    }
    /**
     * Get the model of the vehicle in service with the specific index
     * @param index 
     * @return return the given model of the vehicle
     */
    public String getModel(int index) {
        if (index >= 0 && index < service.length){
            return service[index].getModel();
        }
        else {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }
    //function used in the VehicleRentalTest to test the function of getString function
    public String getString(int index) {
        
        if (index >= 0 && index < service.length){
            return service[index].toString();
        }
        else {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }
    //Function returning the number of vehicles in the service
    public int getNumVehicles() {
        return numVehicles;
    }
    //Return the total capacity of the service (length)
    public int capacity() {
        return totalCapa;
    }
    //Function to add the vehicle into the service
    public void addVehicle(Vehicle vehicle) {
        if(numVehicles < service.length){
            service[numVehicles++] = vehicle;
        } else {
            throw new IllegalStateException("No more vehicles can be added");
        }
    }
    //function to mark the vehicle as rented
    public void rentVehicle(int index) {
        if(index >= 0 && index < service.length){
            service[index].rent();
        }
        else {
            throw new IndexOutOfBoundsException("Invalid index: "+ index);
        }
    }
    //function to mark the vehicle as not rented
    public void returnVehicle(int index) {
        if( index>= 0 && index < service.length){
            service[index].returnVehicle();
        }else{
            throw new IndexOutOfBoundsException("Invalid index"+index);
        }
    }
    /**
     * function to calculate the rental cost of the vehicle with the specific index base on the days and insurance plan
     * 
     * @param index
     * @param days
     * @param insurancePlan

     * @return the rental cost of the vehicle by envoking the method calculateRentalCost in it
    */
    public double calculateRentalCost(int index, int days, InsurancePlan insurancePlan) {
        if(index >= 0 && index < service.length){
            return service[index].calculateRentalCost(days , insurancePlan);// envoke the funcion calculateRentalCost overidden in the classes car and motorbike
        } else {
            throw new IndexOutOfBoundsException("Invalid index" + index);
        }
    }
    /**
     * Method to find the first available vehicle
     * If the vehicle is in the service and not rent, return its index
     * If no vehicle is available, return -1
     * @return
    */
    public int firstAvailable(){
        for (int i = 0; i < service.length; i++){
            if (service[i] != null && !service[i].isRented){
            return i;
            }}
            return -1;
        }
        
    @Override
    public Iterator<Vehicle> iterator() {
        return new VehicleIterator();
    }

    private class VehicleIterator implements Iterator<Vehicle> {
        private int index = 0;
        @Override
        public boolean hasNext() {
            return index < numVehicles;
        }

        @Override
        public Vehicle next() {
            if (hasNext()){
                return service[index++];
            }
            throw new NoSuchElementException();
        }
    }
}
