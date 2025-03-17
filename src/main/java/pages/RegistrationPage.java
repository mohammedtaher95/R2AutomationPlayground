package pages;

import driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistrationPage {

    public Driver driver;

    By pageTitle = By.xpath("(//h2[@class=\"title text-center\"])[1]");
    By password = By.id("password");
    By firstName = By.id("first_name");
    By lastName = By.id("last_name");
    By address = By.id("address1");
    By state = By.id("state");
    By city = By.id("city");
    By country = By.id("country");
    By zipCode = By.xpath("//input[@data-qa=\"zipcode\"]");
    By mobileNumber = By.xpath("//input[@data-qa=\"mobile_number\"]");
    By createAccountButton = By.xpath("//button[@data-qa=\"create-account\"]");

    public RegistrationPage(Driver driver) {
        this.driver = driver;
    }

    /***************************************** Assertions  ******************************************/

    public RegistrationPage checkThatRegistrationPageShouldBeLoadedSuccessfully() {
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/signup"));
        Assert.assertEquals(driver.element().getTextOf(pageTitle), "ENTER ACCOUNT INFORMATION");
        return this;
    }

    /******************************************* Actions ********************************************/

    public RegistrationPage fillInRegistrationPage() {
        driver.get().findElement(password).sendKeys("12345678");
        driver.get().findElement(firstName).sendKeys("Mohammed");
        driver.get().findElement(lastName).sendKeys("Taher");
        driver.get().findElement(address).sendKeys("Alexandria");
        driver.get().findElement(state).sendKeys("Alex");
        driver.get().findElement(city).sendKeys("Alex");

        driver.element().selectByValue(country, "Canada");

        driver.get().findElement(zipCode).sendKeys("21500");
        driver.get().findElement(mobileNumber).sendKeys("01234456978");
        return this;
    }

    public RegistrationSuccessPage clickOnCreateAccountButton() {
        //driver.element().scrollToElement(createAccountButton);
        driver.element().click(createAccountButton);
        return new RegistrationSuccessPage(driver);
    }
}
