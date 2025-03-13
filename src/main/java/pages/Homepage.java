package pages;

import driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Homepage {

    private Driver driver;

    By loginSignUpLink = By.xpath("//a[@href=\"/login\"]");
    By logoutLink = By.xpath("//a[@href=\"/logout\"]");
    By deleteAccountLink = By.xpath("//a[@href=\"/delete_account\"]");

    public Homepage(Driver driver) {
        this.driver = driver;
    }

    /*********************************** Assertions ********************************************/

    public Homepage checkThatUserShouldBeNavigatedToHomePageSuccessfully() {
        Assert.assertEquals(driver.browser().getCurrentURL(), "https://www.automationexercise.com/");
        return this;
    }

    public Homepage checkThatLoginLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(loginSignUpLink));
        return this;
    }

    public Homepage checkThatLogoutLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(logoutLink));
        return this;
    }

    public Homepage checkThatDeleteAccountLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(deleteAccountLink));
        return this;
    }

    /************************************* Actions *********************************************/

    public LoginSignUpPage clickOnLoginSignUpPage() {
        driver.element().click(loginSignUpLink);
        return new LoginSignUpPage(driver.get());
    }

    public LoginSignUpPage clickOnLogoutLink(){
        driver.element().click(logoutLink);
        return new LoginSignUpPage(driver.get());
    }

    public AccountDeletionPage clickOnDeleteAccountPage() {
        driver.element().click(deleteAccountLink);
        return new AccountDeletionPage(driver.get());
    }


}
