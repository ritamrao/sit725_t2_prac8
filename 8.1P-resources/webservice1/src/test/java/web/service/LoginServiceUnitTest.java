package web.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LoginServiceUnitTest {
	@Test
    public void testLoginSuccess() {
        // Test successful login with valid credentials
        assertTrue(LoginService.login("ritam", "ritam_pass", "2001-06-02"));
    }

    @Test
    public void testLoginFailureInvalidUsername() {
        // Test unsuccessful login with invalid username
        assertFalse(LoginService.login("InvalidUsername", "ritam_pass", "2001-06-02"));
    }

    @Test
    public void testLoginFailureInvalidPassword() {
        // Test unsuccessful login with invalid password
        assertFalse(LoginService.login("ritam", "InvalidPassword", "2001-06-02"));
    }

    @Test
    public void testLoginFailureInvalidDob() {
        // Test unsuccessful login with invalid date of birth
        assertFalse(LoginService.login("ritam", "ritam_pass", "1999-12-31"));
    }

    @Test
    public void testLoginFailureEmptyFields() {
        // Test unsuccessful login with empty input fields
        assertFalse(LoginService.login("", "", ""));
    }
    
    @Test
    public void testLoginFailureEmptyUsername() {
        // Test unsuccessful login with empty input fields
        assertFalse(LoginService.login("", "ritam_pass", "2001-06-02"));
    }
    
    @Test
    public void testLoginFailureEmptyPassword() {
        // Test unsuccessful login with empty input fields
        assertFalse(LoginService.login("ritam", "", "2001-06-02"));
    }
    
    @Test
    public void testLoginFailureEmptyDob() {
        // Test unsuccessful login with empty input fields
        assertFalse(LoginService.login("ritam", "ritam_pass", ""));
    }
    @Test
    public void testNullUsername() {
        assertFalse(LoginService.login(null, "ritam_pass", "2001-06-02"));
    }

    @Test
    public void testNullPassword() {
        assertFalse(LoginService.login("ritam", null, "2001-06-02"));
    }

    @Test
    public void testNullDOB() {
        assertFalse(LoginService.login("ritam", "ritam_pass", null));
    }

    @Test
    public void testAllNull() {
        assertFalse(LoginService.login(null, null, null));
    }

    @Test
    public void testWhitespaceInput() {
        assertTrue(LoginService.login("  ritam  ", "  ritam_pass  ", "  2001-06-02  "));
    }

}