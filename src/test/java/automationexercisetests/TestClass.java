package automationexercisetests;

import driverfactory.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.Homepage;
import pages.LoginSignUpPage;
import utilities.ScreenshotManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;

public class TestClass {

    public Driver driver;

    @BeforeClass
    @Parameters(value = {"browserName"})
    public void setup(@Optional("CHROME") String browserName) {
        driver = new Driver(browserName);
        driver.browser().navigateToURL("https://www.automationexercise.com/");
    }

    @Test(priority = 1)
    public void userShouldRegisterSuccessfully() {
        new Homepage(driver).clickOnLoginSignUpPage()
                .checkThatSignUpFormTitleShouldBeDisplayed()
                .fillSignUpForm("Mohammed", "test3875838878@test.com")
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

//    @AfterMethod
//    public void screenShotOnFailure(ITestResult testResult) {
//
//        if(testResult.getStatus() == ITestResult.FAILURE) {
//
//
//            ScreenshotManager.captureScreenshot(driver.get(), testResult.getName());
//
//        }
//    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
