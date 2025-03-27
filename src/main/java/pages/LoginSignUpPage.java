package pages;

import driverfactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSignUpPage {

    private Driver driver;

    By signUpFormHeader = By.xpath("//div[@class=\"signup-form\"]/h2");
    By loginFormHeader = By.xpath("//div[@class=\"login-form\"]/h2");
    By nameField = By.name("name");
    By signUpEmailField = By.xpath("//input[@data-qa=\"signup-email\"]");
    By signUpButton = By.xpath("//button[@data-qa=\"signup-button\"]");
    By loginEmailField = By.xpath("//input[@data-qa=\"login-email\"]");
    By passwordField = By.name("password");
    By loginButton = By.xpath("//button[@data-qa=\"login-button\"]");
    By incorrectLoginCredentialmsg = By.xpath("//form[@action=\"/login\"]/p");
    By existingEmailerror = By.xpath("//p[contains(text(), \"Email Address already exist!\")]");


    String signUpFormTitle = "New User Signup!";
    String loginFormTitle = "Login to your account";
    String incorrectLoginCredentials;
    String existingEmailMessage = "Email Address already exist!";

    public LoginSignUpPage(Driver driver) {
        this.driver = driver;
    }

    /************************************ Assertions *******************************************/

    @Step("checkThatSignUpFormTitleShouldBeDisplayed")
    public LoginSignUpPage checkThatSignUpFormTitleShouldBeDisplayed() {
        Assert.assertEquals(driver.element().getTextOf(signUpFormHeader), signUpFormTitle);
        return this;
    }

    @Step("checkThatLoginFormTitleShouldBeDisplayed")
    public LoginSignUpPage checkThatLoginFormTitleShouldBeDisplayed() {
        Assert.assertEquals(driver.element().getTextOf(loginFormHeader), loginFormTitle);
        return this;
    }

    @Step("checkThatExistingEmailErrorShouldBeDisplayed")
    public LoginSignUpPage checkThatExistingEmailErrorShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(existingEmailerror));
        Assert.assertEquals(driver.element().getTextOf(existingEmailerror), existingEmailMessage);
        return this;
    }

    /************************************** Actions ********************************************/

    @Step("fillSignUpForm")
    public LoginSignUpPage fillSignUpForm(String name, String email) {
        driver.element().type(nameField, name);
        driver.element().type(signUpEmailField, email);
        return this;
    }

    @Step("fillInLoginEmailField")
    public LoginSignUpPage fillInLoginEmailField(String email) {
        driver.element().type(loginEmailField, email);
        return this;
    }

    @Step("fillInPasswordField")
    public LoginSignUpPage fillInPasswordField(String password) {
        driver.element().type(passwordField, password);
        return this;
    }

    @Step("clickOnLoginButton")
    public Homepage clickOnLoginButton() {
        driver.element().click(loginButton);
        return new Homepage(driver);
    }

    @Step("clickOnSignUpButton")
    public RegistrationPage clickOnSignUpButton() {
        driver.element().click(signUpButton);
        return new RegistrationPage(driver);
    }
}
