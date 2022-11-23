package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginSuccessfully() {
        //Click on the Sign-In link
        clickOnElement(By.linkText("Sign In"));
        //Verify the text
        String expectedMessage = "Welcome Back!";
        String actualTextMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome Back!')]"));


        //Validate actual and expected message
        Assert.assertEquals("Welcome Back!", expectedMessage, actualTextMessage);
    }

    @Test
    public void VerifyTheErrorMessage() {
        //Click on the Sign-In link
        clickOnElement(By.linkText("Sign In"));
        //Enter invalid username
        sendTextToElement(By.id("user[email]"), "test123@gmail.com");
        //Enter invalid password
        sendTextToElement(By.id("user[password]"), "test123");
        //Click on login Button
        clickOnElement(By.xpath("//input[@type='submit']"));

        String expectedMessage = "Invalid email or password.";
        String actualTextMessage = getTextFromElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));


        //Validate actual and expected message
        Assert.assertEquals("Error message not display.", expectedMessage, actualTextMessage);
    }

    @After
    public void testDown() {
        closeBrowser();

    }

}

