package automationexercisetests;

import driverfactory.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.LoginSignUpPage;

import java.time.Duration;

public class TestClass {

    private Driver driver;

    @BeforeClass
    public void setup() {
        driver = new Driver("CHROME");
        driver.browser().navigateToURL("https://www.automationexercise.com/");
    }

    @Test(priority = 1)
    public void userShouldRegisterSuccessfully() {
        new Homepage(driver).clickOnLoginSignUpPage()
                .checkThatSignUpFormTitleShouldBeDisplayed()
                .fillSignUpForm("Mohammed", "test3873888878@test.com")
                .clickOnSignUpButton()
                .checkThatRegistrationPageShouldBeLoadedSuccessfully()
                .fillInRegistrationPage()
                .clickOnCreateAccountButton()
                .checkThatSuccessMessageShouldBeDisplayed()
                .clickOnContinueButton()
                .checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                .checkThatLogoutLinkShouldBeDisplayed()
                .checkThatDeleteAccountLinkShouldBeDisplayed();
    }

    @Test(priority = 2, dependsOnMethods = {"userShouldRegisterSuccessfully"})
    public void userCanLogoutSuccessfully() {
        new Homepage(driver).clickOnLogoutLink().checkThatLoginFormTitleShouldBeDisplayed();
    }

    @Test(priority = 3, dependsOnMethods = {"userCanLogoutSuccessfully"})
    public void userCanLoginSuccessfully() {
        new LoginSignUpPage(driver).fillInLoginEmailField("test3635878@test.com")
                .fillInPasswordField("12345678")
                .clickOnLoginButton()
                .checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                .checkThatLogoutLinkShouldBeDisplayed()
                .checkThatDeleteAccountLinkShouldBeDisplayed();
    }

    @Test(priority = 4, dependsOnMethods = {"userCanLoginSuccessfully"})
    public void userCanDeleteAccountSuccessfully() {
        new Homepage(driver).clickOnDeleteAccountPage()
                .checkThatAccountShouldBeDeletedSuccessfully()
                .clickOnContinueButton()
                .checkThatLoginLinkShouldBeDisplayed();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
