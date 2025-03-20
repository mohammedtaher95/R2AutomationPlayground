package automationexercisetests;

import driverfactory.Driver;
import org.testng.annotations.*;
import pages.Homepage;
import pages.LoginSignUpPage;

public class TestClass {

    public ThreadLocal<Driver> driver;

    @BeforeClass
    @Parameters(value = {"browserName"})
    public void setup(@Optional("CHROME") String browserName) {
        driver = new ThreadLocal<>();
        driver.set(new Driver(browserName));
        driver.get().browser().navigateToURL("https://www.automationexercise.com/");
    }

    @Test(priority = 1)
    public void userShouldRegisterSuccessfully() {
        new Homepage(driver.get()).clickOnLoginSignUpPage()
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
        new Homepage(driver.get()).clickOnLogoutLink().checkThatLoginFormTitleShouldBeDisplayed();
    }

    @Test(priority = 3, dependsOnMethods = {"userCanLogoutSuccessfully"})
    public void userCanLoginSuccessfully() {
        new LoginSignUpPage(driver.get()).fillInLoginEmailField("test3635878@test.com")
                .fillInPasswordField("12345678")
                .clickOnLoginButton()
                .checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                .checkThatLogoutLinkShouldBeDisplayed()
                .checkThatDeleteAccountLinkShouldBeDisplayed();
    }

    @Test(priority = 4, dependsOnMethods = {"userCanLoginSuccessfully"})
    public void userCanDeleteAccountSuccessfully() {
        new Homepage(driver.get()).clickOnDeleteAccountPage()
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
        driver.get().quit();
    }
}
