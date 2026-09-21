/**
 * This class is for testing all the cases in my code
 * @author Manh Van Le c3503668
 * @version 1.0, 4 April 2025
*/
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class VehicleRentalTests {
    private VehicleRentalService service;
    //Set up method to initialise a new object before each testing
    @BeforeEach
    void setUp() {

        //Create a new vehicleRentalService with the capacity of 3 instead of 10 because I want to test some function that throw the IllegalState exception 
        service = new VehicleRentalService(3);

        //Create a car and a motorbike with different daily rate
        Vehicle car = new Car( "Toyota", 50);
        Vehicle bike = new Motorcycle("Harley", 20);
        //Add car and motorbike into the service 
        service.addVehicle(car);
        service.addVehicle(bike);

    }
    //Test the function addVehicle() to add if it adds more vehicle when it reaches the limit
    @Test
    void testCantHaveMoreVehicle() {
        Vehicle car1 = new Car("BMw", 50);
        Vehicle car2 = new Car("Kia", 50);
        service.addVehicle(car2);
        assertThrows(IllegalStateException.class, () -> service.addVehicle(car1));
    }
    //Test the function renting vehicle
    @Test
    void testRentVehicle() {
        service.rentVehicle(0);
        assertEquals(1,service.firstAvailable());
    }
    //Test the fuction renting the vehicle that has the index not in the service (capacity = 3)
    @Test 
    void testRentVehicleOutOfIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> service.rentVehicle(3));
    }
    //Test if the mutator gets the right value
    @Test
    void testGetModel() {
        assertEquals("Toyota", service.getModel(0));
    }
    //Test when the mutator returns the model of a vehicle that not in the service
    @Test
    void testGetModelOutBound() {
        assertThrows(IndexOutOfBoundsException.class, () -> service.getModel(3));
    }
    //Test if the calculateRentalCost for car returns the right value over 7 days
    @Test
    void testCalculateRentalCostCar() {
        InsurancePlan basicInsurance = new BasicInsurance();
        assertEquals(550, service.calculateRentalCost(0,  10, basicInsurance));
    }
    //Test if the calculateRentalCost for car returns the right value 30 days
    @Test
    void testCalculateRentalCostCar30days() {
        InsurancePlan basicInsurance = new BasicInsurance();
        assertEquals(1650, service.calculateRentalCost(0,  30, basicInsurance));
    }
    //Test if the calculateRentalCost for car returns the right value over 30 days
    @Test
    void testCalculateRentalCostCarOver30days() {
        InsurancePlan basicInsurance = new BasicInsurance();
        assertEquals(1550, service.calculateRentalCost(0,  31, basicInsurance));
    }
    //Test if the calculateRentalCost for car returns the right value under 7 days
    @Test
    void testCalculateRentalCostCarUnder7days() {
        InsurancePlan basicInsurance = new BasicInsurance();
        assertEquals(420, service.calculateRentalCost(0,  7, basicInsurance));
    }
    //Test if the calculateRentalCost for bike returns the right value over 7 days
    @Test
    void testCalculateRentalCostBike() {
        InsurancePlan basicInsurance = new BasicInsurance();
        assertEquals(290, service.calculateRentalCost(1,  10, basicInsurance));
    }
    //Test if the calculateRentalCost for bike returns the right value 30 days
    @Test
    void testCalculateRentalCostBike30days() {
        InsurancePlan basicInsurance = new BasicInsurance();
        assertEquals(870, service.calculateRentalCost(1,  30, basicInsurance));
    }
    //Test if the calculateRentalCost for bike returns the right value over 30 days
    @Test
    void testCalculateRentalCostBikeOver30days() {
        InsurancePlan basicInsurance = new BasicInsurance();
        assertEquals(837, service.calculateRentalCost(1,  31, basicInsurance));
    }
    //Test if the calculateRentalCost for bike returns the right value under 7 days
    @Test
    void testCalculateRentalCostBikeUnder7days() {
        InsurancePlan basicInsurance = new BasicInsurance();
        assertEquals(210, service.calculateRentalCost(1,  7, basicInsurance));
    }
    @Test 
    void testCalculateRentalCostDaysLessThanZero() {
        InsurancePlan basicInsurance = new BasicInsurance();
        assertThrows(IllegalArgumentException.class, () -> service.calculateRentalCost(0, 0, basicInsurance));
        assertThrows(IllegalArgumentException.class, () -> service.calculateRentalCost(1, 0, basicInsurance));
    }
    //Test to calculate the vehicle that not in the service
    @Test
    void testCalculateRentalCostOutOfIndex() {
        InsurancePlan basicInsurance = new BasicInsurance();
        assertThrows(IndexOutOfBoundsException.class, () -> service.calculateRentalCost(3, 10, basicInsurance));
    }
    //Test the firstAvailability function when no vehicle is rented
    @Test
    void testFirstAvailability() {
        int nextAvailable = service.firstAvailable();
        assertEquals(0 , nextAvailable);
    }
    //Test the firstAvailabiliy function when all vehicle is rented
    @Test
    void testReturnNoAvailability() {
        int nextAvailable;
        service.rentVehicle(0);
        service.rentVehicle(1);
        nextAvailable = service.firstAvailable();
        assertEquals(-1, nextAvailable);
    }
    //Test if the function toString return the right value of the vehicle
    @Test
    void testToString() {
        assertEquals("Car Model: Toyota, Daily Rate: $50.0", service.getString(0));
    }
    //Test if the function getString throws the index out of bound exception
    @Test
    void testToStringException() {
        assertThrows(IndexOutOfBoundsException.class,() -> service.getString(-1));
    }
    //Test if the function capacity returns the capacity properly
    @Test
    void testCapacity() {
        assertEquals(3, service.capacity());
    }
    //Test if the function getNumVehicle returns the number of vehicle properly
    @Test
    void testNumOfVe() {
        assertEquals(2, service.getNumVehicles());
        Vehicle car1 = new Car("Honda", 50);
        service.addVehicle(car1);
        assertEquals(3, service.getNumVehicles());
    }
    //Test the function return if it works properly
    @Test
    void testReturn() {
        assertEquals(0, service.firstAvailable());
        service.rentVehicle(0);
        assertEquals(1, service.firstAvailable());
        service.returnVehicle(0);
        assertEquals(0,service.firstAvailable());
        service.returnVehicle(0);
    }
    //Test the function return when return a vehicle that out of index
    @Test
    void testReturnOutIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> service.returnVehicle(4));
    }
    //Test the function get the daily rate of the premium insurance
    @Test
    void testGetDailyRate() {
        InsurancePlan premiumInsurance = new PremiumInsurance();
        assertEquals(30, premiumInsurance.getDailyRate());
    }
    //Test the iterator
    @Test
    void testIterator() {
        Iterator<Vehicle> iterator = service.iterator();
        assertTrue(iterator.hasNext());
        Vehicle vehicle = iterator.next();
        assertNotNull(vehicle);
        Vehicle vehicle1 = iterator.next();
        assertNotNull(vehicle1);
        assertThrows(NoSuchElementException.class, () ->iterator.next());
    }
}