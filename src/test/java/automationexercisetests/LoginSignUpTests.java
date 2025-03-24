package automationexercisetests;

import driverfactory.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.Homepage;
import pages.LoginSignUpPage;

import java.time.Duration;

public class LoginSignUpTests {

    private ThreadLocal<Driver> driver;

    @BeforeMethod
    public void setup() {
        driver = new ThreadLocal<>();
        driver.set(new Driver());
    }

    @Test
    public void registerWithExistingEmail() {
        new Homepage(driver.get()).clickOnLoginSignUpPage()
                .checkThatSignUpFormTitleShouldBeDisplayed()
                .fillSignUpForm("Mohammed", "test@test.com")
                .clickOnSignUpButton();

        new LoginSignUpPage(driver.get()).checkThatExistingEmailErrorShouldBeDisplayed();
    }

    @AfterMethod
    public void tearDown() {
        driver.get().quit();
    }
}
