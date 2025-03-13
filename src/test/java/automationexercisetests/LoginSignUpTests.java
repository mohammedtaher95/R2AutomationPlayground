package automationexercisetests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.LoginSignUpPage;

import java.time.Duration;

public class LoginSignUpTests {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();
        driver.navigate().to("https://www.automationexercise.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
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
