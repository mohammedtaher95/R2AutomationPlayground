package driverfactory;

import browseractions.BrowserActions;
import elementactions.ElementActions;
import org.openqa.selenium.WebDriver;

public class Driver {

    private WebDriver driver;

    public Driver(String driver) {
        this.driver = getDriver(driver).startDriver();
        System.out.println("Starting the execution via " + driver + " driver");
        this.driver.manage().window().maximize();
    }

    private DriverAbstract getDriver(String driver) {
        switch (driver.toUpperCase()) {
            case "CHROME": {
                return new ChromeDriverFactory();
            }
            case "FIREFOX": {
                return new FirefoxDriverFactory();
            }
            case "EDGE": {
                return new EdgeDriverFactory();
            }
            default: {
                throw new IllegalStateException("Unexpected value: " + driver);
            }
        }
    }

    public WebDriver get() {
        return this.driver;
    }

    public void quit() {
        driver.quit();
    }

    public ElementActions element() {
        return new ElementActions(driver);
    }

    public BrowserActions browser() {
        return new BrowserActions(driver);
    }
}
