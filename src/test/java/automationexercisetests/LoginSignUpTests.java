package automationexercisetests;

import driverfactory.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.Homepage;
import pages.LoginSignUpPage;

import java.time.Duration;

public class LoginSignUpTests {

    private Driver driver;

    @BeforeMethod
    @Parameters(value = {"browserName"})
    public void setup(@Optional("CHROME") String browserName) {
        driver = new Driver(browserName);
        driver.browser().navigateToURL("https://www.automationexercise.com/");
    }

    @Test
    public void registerWithExistingEmail() {
        new Homepage(driver).clickOnLoginSignUpPage()
                .checkThatSignUpFormTitleShouldBeDisplayed()
                .fillSignUpForm("Mohammed", "test@test.com")
                .clickOnSignUpButton();

        new LoginSignUpPage(driver).checkThatExistingEmailErrorShouldBeDisplayed();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
