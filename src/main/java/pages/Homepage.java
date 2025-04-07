package pages;

import driverfactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
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

    @Step("check That User Should Be Navigated To Home Page Successfully")
    public Homepage checkThatUserShouldBeNavigatedToHomePageSuccessfully() {
        Assert.assertEquals(driver.browser().getCurrentURL(), "https://www.automationexercise.com/");
        return this;
    }

    @Step("check That Login Link Should Be Displayed")
    public Homepage checkThatLoginLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(loginSignUpLink));
        return this;
    }

    @Step("check That Logout Link Should Be Displayed")
    public Homepage checkThatLogoutLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(logoutLink));
        return this;
    }

    @Step("check That Delete Account Link Should Be Displayed")
    public Homepage checkThatDeleteAccountLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(deleteAccountLink));
        return this;
    }

    /************************************* Actions *********************************************/

    @Step("clickOnLoginSignUpPage")
    public LoginSignUpPage clickOnLoginSignUpPage() {
        driver.element().click(loginSignUpLink);
        return new LoginSignUpPage(driver);
    }

    @Step("clickOnLogoutLink")
    public LoginSignUpPage clickOnLogoutLink(){
        driver.element().click(logoutLink);
        return new LoginSignUpPage(driver);
    }

    @Step("clickOnDeleteAccountPage")
    public AccountDeletionPage clickOnDeleteAccountPage() {
        driver.element().click(deleteAccountLink);
        return new AccountDeletionPage(driver);
    }


}
