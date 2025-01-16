package com.example.api;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extentReports;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();


    public static ExtentReports getInstance(){
        if(extentReports == null){
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter("reports/extent-report.html");
            extentReports = new ExtentReports();
            extentReports.attachReporter(htmlReporter);
        }
        return extentReports;
    }

      public static ExtentTest createTest(String testName) {
        // Use ThreadLocal to ensure that each thread gets its own ExtentTest instance
        test.set(getInstance().createTest(testName));
        return test.get();
    }

    // Finalize and generate the report
    public static void flush() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }

}




