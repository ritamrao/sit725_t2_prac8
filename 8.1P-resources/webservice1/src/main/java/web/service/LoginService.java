package web.service;

/**
 * Business logic to handle login functions.
 * 
 * @author Ahsan.
 */
public class LoginService {

	/**
	 * Static method returns true for successful login, false otherwise.
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean login(String username, String password, String dob) {
		// Match a fixed user name and password.
		//
		if ("ritam".equals(username) && "ritam_pass".equals(password) && "2001-06-02".equals(dob)) {
			return true;
		}
		return false;
	}
	
	
}
