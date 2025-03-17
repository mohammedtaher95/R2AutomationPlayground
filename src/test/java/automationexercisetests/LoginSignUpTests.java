package automationexercisetests;

import driverfactory.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.LoginSignUpPage;

import java.time.Duration;

public class LoginSignUpTests {

    private Driver driver;

    @BeforeMethod
    public void setup() {
        driver = new Driver("cHroME");
        driver.get().navigate().to("https://www.automationexercise.com/");
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
