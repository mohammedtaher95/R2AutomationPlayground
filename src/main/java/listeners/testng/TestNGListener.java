package listeners.testng;

import driverfactory.Driver;
import org.testng.IExecutionListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.ScreenshotManager;

import java.lang.reflect.Field;

public class TestNGListener implements IExecutionListener, ITestListener {


    @Override
    public void onExecutionStart() {
        System.out.println("**************** Welcome to Selenium Framework *****************");
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("********************* End of Execution *********************");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("*******  Starting Test: " + result.getName() + " ***************");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("*******  Success of Test: " + result.getName() + " ***************");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed...");
        System.out.println("Taking Screenshot......");

        Driver driver = null;
        Object currentClass = result.getInstance();
        Field[] fields = result.getTestClass().getRealClass().getDeclaredFields();

        try {
            for(Field field: fields){
                if(field.getType() == Driver.class) {
                    driver = (Driver) field.get(currentClass);
                }
            }
        } catch (IllegalAccessException exception) {
            System.out.println("Unable to get field, Field Should be public");
        }
        assert driver != null;
        ScreenshotManager.captureScreenshot(driver.get(), result.getName());
    }
}
