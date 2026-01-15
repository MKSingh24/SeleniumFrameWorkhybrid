package com.org.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.org.utilities.ScreenshotUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentReportManager.getReporter();
    ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public void onTestStart(ITestResult result) {
        ExtentTest t = extent.createTest(result.getMethod().getMethodName());
        test.set(t);
    }

    public void onTestSuccess(ITestResult result) {
        String path = ScreenshotUtil.captureScreenshot("PASS", result.getName());
//        test.get().pass("Test Passed").addScreenCaptureFromPath(path);
        test.get().pass("Test Passed").addScreenCaptureFromBase64String(path);
    }

    public void onTestFailure(ITestResult result) {
        String path = ScreenshotUtil.captureScreenshot("FAIL", result.getName());
//        test.get().fail(result.getThrowable()).addScreenCaptureFromPath(path);
        test.get().fail(result.getThrowable());
        test.get().addScreenCaptureFromBase64String(path);
    }

    public void onTestSkipped(ITestResult result) {
        String path = ScreenshotUtil.captureScreenshot("SKIP", result.getName());
        test.get().skip("Test Skipped").addScreenCaptureFromBase64String(path);
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }

}
