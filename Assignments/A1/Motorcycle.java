/**
 *  This class defines how to calculate the rental cost of motorbike base on the given inputs
 * It also returns the type of each vehicle (motorcycle)
 * @author Manh Van Le c3503668
 * @version 1.0, 4 April 2025
*/
public class Motorcycle extends Vehicle {
    public Motorcycle(String model, double dailyRate) { //initialise the new motorcycle object with the two values: model and dailyRate
        super(model, dailyRate);
    }

    @Override
    protected String getType() {
        return "Motorcycle";//return the string "Motorcycle" if a motorcycle object calls it
    }
    @Override
    public double calculateRentalCost(int days, InsurancePlan insurancePlan) {
        double fee,total = 0 ;
        fee = insurancePlan.getDailyRate();
        if (days <= 0){
            throw new IllegalArgumentException("Renting days must be greater than 0"); // If user inputs days <= 0, an exception is thrown
        }
        if (days > 7 && days <= 30) {
            total = (dailyRate*0.95+fee)*days;//5% discount 
        }
        else if (days > 30) {
            total = (dailyRate*0.85+fee)*days;//15% discount
        }
        else {
            total = (dailyRate+ fee)*days;//no discount
        }
        return total;
    }
}