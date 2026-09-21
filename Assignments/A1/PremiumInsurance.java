/** 
 * This class only overrides the getDailyRate() method of the class InsurancePlan
 * @author Manh Van Le c3503668
 * @version 1.0, 4 April 2025
 */
public class PremiumInsurance implements InsurancePlan {
    @Override
    public double getDailyRate() {
        return 30;
    }
}