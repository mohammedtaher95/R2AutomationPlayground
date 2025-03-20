package driverfactory;

import browseractions.BrowserActions;
import elementactions.ElementActions;
import org.openqa.selenium.WebDriver;

public class Driver {

    private ThreadLocal<WebDriver> driver;

    public Driver(String driverType) {
        driver = new ThreadLocal<>();
        driver.set(getDriver(driverType).startDriver());
        System.out.println("Starting the execution via " + driver + " driver");
        driver.get().manage().window().maximize();
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
        return driver.get();
    }

    public void quit() {
        driver.get().quit();
    }

    public ElementActions element() {
        return new ElementActions(driver.get());
    }

    public BrowserActions browser() {
        return new BrowserActions(driver.get());
    }
}
