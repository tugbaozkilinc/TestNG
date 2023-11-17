package techproed.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("onStart/It runs before all tests just once: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish/It runs after all tests just once: " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart/It runs before each test just once: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess/It runs after only tests which passed just once: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("onTestFailure/It runs after only tests which failed just once: " + result.getName());
        ReusableMethods.takeScreenshotOfPage("Test-Case-Fail-" + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped/It runs after only tests which skipped just once:  " + result.getName());
    }

}
