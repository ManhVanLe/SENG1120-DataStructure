/**
 * Train represents a train that consists of a sequence of train cars.
 * It provides methods to add and remove cars, get a car by index, and print the train's composition.
 * @author Van Manh Le , c3503668
 * @version 1.0 11st May 2025
 * @see TrainCar
 */
public class Train {
    /**
     * The list of train cars in the train.
     */
    private LinkedList<TrainCar> cars;

    /**
     * Initialises a Train with an empty list of cars.
     */
    public Train() {
        cars = new LinkedList<>();
    }

    /**
     * Adds a new train car to the end of the train.
     * 
     * @param car the train car to be added
     */
    public void addCar(TrainCar car) {
        cars.addLast(car);
    }

    /**
     * Removes a train car from the train by its ID.
     * 
     * @param carId the ID of the train car to be removed
     * @return true if the car was removed successfully, false otherwise
     */
    public boolean removeCar(int carId) {
        for (int i = 0; i <cars.size(); i++){
            TrainCar car = cars.get(i);
            if (car.getCarId() == carId) {
                cars.remove(i);
                return true;
            }
        }
        return false;
    }
    /**
     * Gets a train car by its index in the list.
     * This should throw an exception if the index is out of bounds.
     * 
     * @param index the index of the train car to be retrieved
     * @return the train car at the specified index
     */
    public TrainCar getCar(int index) {
        if (index < 0 || index >= cars.size()){
            throw new IndexOutOfBoundsException();
        }
        return cars.get(index);
    }

    /**
     * Gets the number of train cars in the train.
     * 
     * @return the number of train cars
     */
    public int getSize() {
        return cars.size();
    }

    /**
     * Prints the composition of the train, showing all the train cars.
     * This method iterates through the list of cars and prints each one.
     * This should be implemented using a for-each loop, leveraging the iterator of the list.
     */
    public void printTrain() {
        for (TrainCar car: cars){
            System.out.println(car.toString());
        }
    }
}
