package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSignUpPage {

    private WebDriver driver;

    By signUpFormHeader = By.xpath("//div[@class=\"signup-form\"]/h2");
    By loginFormHeader = By.xpath("//div[@class=\"login-form\"]/h2");
    By nameField = By.name("name");
    By signUpEmailField = By.xpath("//input[@data-qa=\"signup-email\"]");
    By signUpButton = By.xpath("//button[@data-qa=\"signup-button\"]");
    By loginEmailField = By.xpath("//input[@data-qa=\"login-email\"]");
    By passwordField = By.name("password");
    By loginButton = By.xpath("//button[@data-qa=\"login-button\"]");


    String signUpFormTitle = "New User Signup!";
    String loginFormTitle = "Login to your account";

    public LoginSignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    /************************************ Assertions *******************************************/

    public LoginSignUpPage checkThatSignUpFormTitleShouldBeDisplayed() {
        Assert.assertEquals(driver.findElement(signUpFormHeader).getText(), signUpFormTitle);
        return this;
    }

    public LoginSignUpPage checkThatLoginFormTitleShouldBeDisplayed() {
        Assert.assertEquals(driver.findElement(loginFormHeader).getText(), loginFormTitle);
        return this;
    }

    /************************************** Actions ********************************************/

    public LoginSignUpPage fillSignUpForm(String name, String email) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(signUpEmailField).sendKeys(email);
        return this;
    }

    public LoginSignUpPage fillInLoginEmailField(String email) {
        driver.findElement(loginEmailField).sendKeys(email);
        return this;
    }

    public LoginSignUpPage fillInPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public Homepage clickOnLoginButton() {
        driver.findElement(loginButton).click();
        return new Homepage(driver);
    }

    public RegistrationPage clickOnSignUpButton() {
        driver.findElement(signUpButton).click();
        return new RegistrationPage(driver);
    }
}
