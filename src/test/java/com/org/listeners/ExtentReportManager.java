package com.org.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getReporter() {
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("reports/ExtentReport.html");
            reporter.config().setDocumentTitle("Automation Report");
            reporter.config().setReportName("Hybrid Framework Report");
            reporter.config().setTheme(Theme.STANDARD);
            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        return extent;
    }
}
