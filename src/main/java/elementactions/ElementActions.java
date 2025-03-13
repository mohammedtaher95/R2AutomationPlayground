package elementactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ElementActions {

    private WebDriver driver;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
    }

    public ElementActions click(By locator) {
        System.out.println("Click on: " + locator.toString());
        driver.findElement(locator).click();
        return this;
    }

    public ElementActions type(By locator, String text) {
        clearField(locator);
        System.out.println("Fill field: " + locator.toString() + " with: " + text);
        driver.findElement(locator).sendKeys(text);
        return this;
    }

    public ElementActions clearField(By locator) {
        System.out.println("Clear field with locator: " + locator.toString());
        driver.findElement(locator).clear();
        return this;
    }

    public ElementActions selectByIndex(By locator, int index) {
        System.out.println("Selecting Option " + index + "from dropdown: " + locator.toString());
        new Select(driver.findElement(locator)).selectByIndex(index);
        return this;
    }

    public ElementActions selectByValue(By locator, String value) {
        System.out.println("Selecting Value: " + value + "from dropdown: " + locator.toString());
        new Select(driver.findElement(locator)).selectByValue(value);
        return this;
    }

    public String getTextOf(By locator) {
        System.out.println("Getting text from locator: " + locator.toString());
        return driver.findElement(locator).getText();
    }

    public Boolean isDisplayed(By locator) {
        System.out.println("Checking" + locator.toString().split(":", 2)[1] + " if Displayed");
        return driver.findElement(locator).isDisplayed();
    }

    public Boolean isSelected(By locator) {
        System.out.println("Checking" + locator.toString().split(":", 2)[1] + " if Selected");
        return driver.findElement(locator).isSelected();
    }

    public Boolean isClickable(By locator) {
        System.out.println("Checking" + locator.toString().split(":", 2)[1] + " if Clickable");
        return driver.findElement(locator).isEnabled();
    }
}
