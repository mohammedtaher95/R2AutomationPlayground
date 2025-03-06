package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Homepage {

    private WebDriver driver;

    By loginSignUpLink = By.xpath("//a[@href=\"/login\"]");
    By logoutLink = By.xpath("//a[@href=\"/logout\"]");
    By deleteAccountLink = By.xpath("//a[@href=\"/delete_account\"]");

    public Homepage(WebDriver driver) {
        this.driver = driver;
    }

    /*********************************** Assertions ********************************************/

    public Homepage checkThatUserShouldBeNavigatedToHomePageSuccessfully() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.automationexercise.com/");
        return this;
    }

    public Homepage checkThatLoginLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.findElement(loginSignUpLink).isDisplayed());
        return this;
    }

    public Homepage checkThatLogoutLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.findElement(logoutLink).isDisplayed());
        return this;
    }

    public Homepage checkThatDeleteAccountLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.findElement(deleteAccountLink).isDisplayed());
        return this;
    }

    /************************************* Actions *********************************************/

    public LoginSignUpPage clickOnLoginSignUpPage() {
        driver.findElement(loginSignUpLink).click();
        return new LoginSignUpPage(driver);
    }

    public LoginSignUpPage clickOnLogoutLink(){
        driver.findElement(logoutLink).click();
        return new LoginSignUpPage(driver);
    }

    public AccountDeletionPage clickOnDeleteAccountPage() {
        driver.findElement(deleteAccountLink).click();
        return new AccountDeletionPage(driver);
    }


}
