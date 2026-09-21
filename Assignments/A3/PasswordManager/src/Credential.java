/**
 * A class to represent a user credential for a specific site.
 * It contains the site name, username, and password, each of which is a string.
 * The class provides methods to get and set the username and password, as well as a method to return a string representation of the credential.
 * 
 * @author Van Manh Le, c3503668
 * @version 1.0, 31/05/2025
 */
public class Credential {

    private String site;
    private String username;
    private String password;

    /**
     * Constructs a new Credential with the given site, username, and password.
     * 
     * @param site the name of the site
     * @param username the username for the site
     * @param password the password for the site
     */
    public Credential(String site, String username, String password) {
        this.site = site;
        this.username = username;
        this.password = password;
    }

    /**
     * Returns the site name of the credential.
     * @return the site name
     */
    public String getSite() { 
        return site;
    }

    /**
     * Returns the username of the credential.
     * @return the username
     */
    public String getUsername() { 
        return username;
    }

    /**
     * Returns the password of the credential.
     * @return the password
     */
    public String getPassword() { 
        return password;
    }

    /**
     * Sets the username of the credential.
     * @param username the new username
     */
    public void setUsername(String username) { 
        this.username = username;
    }

    /**
     * Sets the password of the credential.
     * @param password the new password
     */
    public void setPassword(String password) { 
       this.password = password;
    }

    /**
     * Returns a string representation of the credential.
     * The string includes the site name, username, and password.
     * This should be formatted as follows:
     * 
     * [site] Username: <username>, Password: <password>
     * 
     * @return a string representation of the credential
     */
    @Override
    public String toString() {
        return "[" +site+ "] Username: "+username+ ", Password: "+password;
    }
}