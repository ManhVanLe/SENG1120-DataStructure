/**
 * A simple password strength checker, which is defined by a static method.
 * It evaluates the strength of a password based on length, character types, and complexity.
 * 
 * @author Van Manh Le c3503668
 * @version 1.0, 01/06/2025
 */
public class PasswordStrengthChecker {
    /**
     * Evaluates the strength of a password. 
     * This is a static method that checks the password against a set of criteria.
     * Hence, you need to use it by calling PasswordStrengthChecker.evaluate(password).
     * 
     * The password strength is determined by the following criteria:
     * - Length: At least 8 characters
     * - Contains at least one lowercase letter
     * - Contains at least one uppercase letter
     * - Contains at least one digit
     * - Contains at least one special character (non-alphanumeric)
     * 
     * The strength levels are:
     * - Very Weak: 0 or 1 criteria met
     * - Weak: 2 criteria met
     * - Moderate: 3 criteria met
     * - Strong: 4 criteria met
     * - Very Strong: 5 criteria met
     * 
     * @param password the password to evaluate
     * @return a string indicating the strength of the password, as one of the following:
     * "Very Weak", "Weak", "Moderate", "Strong", "Very Strong"
     */
    public static String evaluate(String password) {
        int score = 0;
        if (password.length() >= 8) {
            score++;
        }
        boolean hasLowercase = false;
        boolean hasUppercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        
        //check each character in the password
        for (int i = 0; i < password.length(); i++) {//If this character meets one of the criteria, turn the boolean expression to true.
            char c = password.charAt(i);
            if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }
        //if any boolean expression is true, add 1 to the score.
        if (hasLowercase)
            score++;
        if (hasUppercase)
            score++;
        if (hasDigit)
            score++;
        if (hasSpecialChar)
            score++; 
        //return the strength level based on the score archieved.
        return switch (score) {
            case 0, 1 -> "Very Weak";
            case 2 -> "Weak";
            case 3 -> "Moderate";
            case 4 -> "Strong";
            case 5 -> "Very Strong";
            default -> "Unknown";
        };
    }
}

