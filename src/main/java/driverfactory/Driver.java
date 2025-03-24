package driverfactory;

import browseractions.BrowserActions;
import elementactions.ElementActions;
import org.openqa.selenium.WebDriver;

import static utilities.PropertiesManager.webConfig;

public class Driver {

    private ThreadLocal<WebDriver> driver;

    public Driver() {
        String driverType = webConfig.getProperty("BrowserType");
        driver = new ThreadLocal<>();
        driver.set(getDriver(driverType).startDriver());
        System.out.println("Starting the execution via " + driverType + " driver");
        driver.get().manage().window().maximize();

        if(!webConfig.getProperty("BaseURL").isEmpty()) {
            driver.get().navigate().to(webConfig.getProperty("BaseURL"));
        }
    }

    public Driver(String driverType) {
        driver = new ThreadLocal<>();
        driver.set(getDriver(driverType).startDriver());
        System.out.println("Starting the execution via " + driver + " driver");
        driver.get().manage().window().maximize();

        if(!webConfig.getProperty("BaseURL").isEmpty()) {
            driver.get().navigate().to(webConfig.getProperty("BaseURL"));
        }
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
