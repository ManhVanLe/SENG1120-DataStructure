/**
 * This class defines how to calculate the rental cost of car based on the given inputs
 * It also returns the type of each vehicle (car)
 *@author Manh Van Le c3503668 
 *@version 1.0, 4 April 2025
 */
public class Car extends Vehicle {
    public Car(String model, double dailyRate) { //initialise the new car object with the two values model and dailyRate
        super(model,dailyRate);
    }

    @Override
    protected String getType() { //method to return the string "Car" when an object in the class Car envokes
        return "Car";
    }
    @Override
    public double calculateRentalCost(int days, InsurancePlan insurancePlan) {
        double fee,total = 0 ;
        fee = insurancePlan.getDailyRate();//Get the daily rate of the correspoding insurance plan
        if (days <= 0){
            throw new IllegalArgumentException("Renting days must be greater than 0"); // If user inputs days <= 0, an exception is thrown
        }
        if (days > 7 && days <=30) {
            total = (dailyRate*0.9+fee)*days ;//10% discount
        }
        else if (days > 30) {
            total = (dailyRate*0.8+fee)*days ;//20% discount
        }
        else {
            total = (dailyRate + fee)*days;//no discount
        }
        return total;
    }
}