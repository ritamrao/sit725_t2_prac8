package web.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginServiceTest {
    private final String CHROME_DRIVER_PATH = "C:\\chromedriver-win64\\chromedriver.exe";
    private final String LOGIN_PAGE_PATH = "file:///C:/Users/ritam/Documents/Deakin%20T2/SIT%20707/Week%208/8.1P-resources/pages/login.html";
    private final String REGISTER_PAGE_PATH = "file:///C:/Users/ritam/Documents/Deakin%20T2/SIT%20707/Week%208/8.1P-resources/pages/register.html";

    private WebDriver driver;

    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLoginSuccess() {
        driver.navigate().to(LOGIN_PAGE_PATH);
        sleep(5);

        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("ritam");

        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys("ritam_pass");

        WebElement dobElement = driver.findElement(By.id("dob"));
        dobElement.clear();
        dobElement.sendKeys("02-06-2001");

        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();

        sleep(5);

        String title = driver.getTitle();
        System.out.println("Title: " + title);

        Assert.assertEquals("success", title);
    }

    @Test
    public void testLoginFailure() {
        driver.navigate().to(LOGIN_PAGE_PATH);
        sleep(5);

        WebElement usernameElement = driver.findElement(By.id("username"));
        usernameElement.clear();
        usernameElement.sendKeys("invalid_user");

        WebElement passwordElement = driver.findElement(By.id("passwd"));
        passwordElement.clear();
        passwordElement.sendKeys("invalid_password");

        WebElement dobElement = driver.findElement(By.id("dob"));
        dobElement.clear();
        dobElement.sendKeys("26-02-2002");

        WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
        submitButton.click();

        sleep(5);

        String title = driver.getTitle();
        System.out.println("Title: " + title);
        Assert.assertEquals("fail", title);
    }

    @Test
    public void testRegisterSuccess() {
        driver.navigate().to(REGISTER_PAGE_PATH);
        sleep(5);

		WebElement fNameElement = driver.findElement(By.id("fname"));
		fNameElement.clear();
		fNameElement.sendKeys("John");

		WebElement lNameElement = driver.findElement(By.id("lname"));
		lNameElement.clear();
		lNameElement.sendKeys("Doe");

		WebElement emailElement = driver.findElement(By.id("email"));
		emailElement.clear();
		emailElement.sendKeys("john.doe@example.com");

		WebElement dobElement = driver.findElement(By.id("dob"));
		dobElement.clear();
		dobElement.sendKeys("01-01-1990"); // Assuming a valid date

		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
		submitButton.click();

		sleep(5);

		// Assuming the server returns a JSON response with status "ok"
		String response = driver.findElement(By.tagName("body")).getText();
		System.out.println("Response: " + response);
		Assert.assertEquals("{\"status\": \"ok\"}", response);

		driver.close();
    }

    @Test
    public void testInvalidUsername() {
        driver.navigate().to(LOGIN_PAGE_PATH);
        sleep(5);

        WebElement usernameElement = driver.findElement(By.id("username"));
        usernameElement.clear();
        usernameElement.sendKeys("invalid_username");

        WebElement passwordElement = driver.findElement(By.id("passwd"));
        passwordElement.clear();
        passwordElement.sendKeys("ritam_pass");

        WebElement dobElement = driver.findElement(By.id("dob"));
        dobElement.clear();
        dobElement.sendKeys("02-06-2001");

        WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
        submitButton.click();

        sleep(5);

        String title = driver.getTitle();
        System.out.println("Title: " + title);
        Assert.assertEquals("fail", title);
    }

    @Test
    public void testInvalidPassword() {
        driver.navigate().to(LOGIN_PAGE_PATH);
        sleep(5);

        WebElement usernameElement = driver.findElement(By.id("username"));
        usernameElement.clear();
        usernameElement.sendKeys("ritam");

        WebElement passwordElement = driver.findElement(By.id("passwd"));
        passwordElement.clear();
        passwordElement.sendKeys("invalid_password");

        WebElement dobElement = driver.findElement(By.id("dob"));
        dobElement.clear();
        dobElement.sendKeys("02-06-2001");

        WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
        submitButton.click();

        sleep(5);

        String title = driver.getTitle();
        System.out.println("Title: " + title);
        Assert.assertEquals("fail", title);
    }

    @Test
    public void testEmptyFields() {
        driver.navigate().to(LOGIN_PAGE_PATH);
        sleep(5);

        WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
        submitButton.click();

        sleep(5);

        String title = driver.getTitle();
        System.out.println("Title: " + title);
        Assert.assertEquals("fail", title);
    }

    @Test
    public void testInvalidDOBFormat() {
        driver.navigate().to(LOGIN_PAGE_PATH);
        sleep(5);

        WebElement usernameElement = driver.findElement(By.id("username"));
        usernameElement.clear();
        usernameElement.sendKeys("ritam");

        WebElement passwordElement = driver.findElement(By.id("passwd"));
        passwordElement.clear();
        passwordElement.sendKeys("ritam_pass");

        WebElement dobElement = driver.findElement(By.id("dob"));
        dobElement.clear();
        dobElement.sendKeys("01*01*1990");

        WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
        submitButton.click();

        sleep(5);

        String title = driver.getTitle();
        System.out.println("Title: " + title);
        Assert.assertEquals("fail", title);
    }

    @Test
    public void testEmptyDOB() {
        driver.navigate().to(LOGIN_PAGE_PATH);
        sleep(5);

        WebElement usernameElement = driver.findElement(By.id("username"));
        usernameElement.clear();
        usernameElement.sendKeys("ritam");

        WebElement passwordElement = driver.findElement(By.id("passwd"));
        passwordElement.clear();
        passwordElement.sendKeys("ritam_pass");

        WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
        submitButton.click();

        sleep(5);

        String title = driver.getTitle();
        System.out.println("Title: " + title);
        Assert.assertEquals("fail", title);
    }

    @Test
    public void testInvalidCredentials() {
        driver.navigate().to(LOGIN_PAGE_PATH);
        sleep(5);

        WebElement usernameElement = driver.findElement(By.id("username"));
        usernameElement.clear();
        usernameElement.sendKeys("invalid_username");

        WebElement passwordElement = driver.findElement(By.id("passwd"));
        passwordElement.clear();
        passwordElement.sendKeys("invalid_password");

        WebElement dobElement = driver.findElement(By.id("dob"));
        dobElement.clear();
        dobElement.sendKeys("02-02-2002");

        WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
        submitButton.click();

        sleep(5);

        String title = driver.getTitle();
        System.out.println("Title: " + title);
        Assert.assertEquals("fail", title);
    }

}


