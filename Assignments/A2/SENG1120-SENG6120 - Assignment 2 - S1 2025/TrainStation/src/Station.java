/**
 * Station represents a train station where passengers can wait to board a train.
 * It maintains a queue of passengers and provides methods to add passengers,
 * board passengers onto a train, and print the current passenger queue.
 * @author Van Manh Le , c3503668
 * @version 1.0 11st May 2025
 * 
 */
public class Station {
    /**
     * The queue of passengers waiting at the station.
     */
    private QueueADT<Passenger> passengerQueue;

    /**
     * Initialises a Station with an empty passenger queue.
     */
    public Station() {
        passengerQueue = new LinkedQueue<>();
    }

    /**
     * Adds a passenger to the station's queue.
     * 
     * @param p the passenger to be added
     */
    public void addPassenger(Passenger p) {
        passengerQueue.enqueue(p);
    }

    /**
     * Boards passengers from the station's queue onto the train.
     * Passengers are boarded into the first available car in the train.
     * 
     * @param train the train to board passengers onto
     */
    public void boardPassengers(Train train) {
        for (int i = 0; i < train.getSize(); i++){
            TrainCar car = train.getCar(i);

            // Only board if the queue isn't empty and the car has no passenger
            if (!passengerQueue.isEmpty() && !car.hasPassenger()){
                Passenger p = passengerQueue.dequeue();
                car.boardPassenger(p);

                //Display who boarded and where
                System.out.println("Boarded " + p.getName()+ " to Car "+ car.getCarId());
            }
        }
    }

    /**
     * Prints the current passenger queue at the station.
     * This method iterates through the queue and prints each passenger's details.
     * This should be implemented using a for-each loop, leveraging the iterator of the queue.
     */
    public void printPassengerQueue() {
        System.out.println("Station Queue:");
        for (Passenger passenger : passengerQueue) {
            System.out.println(passenger);
        }
    }
}
