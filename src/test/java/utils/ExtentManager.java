package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {

    private static ExtentReports extent;

    // Singleton pattern - only one instance of ExtentReports
    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance("target/ExtentReport.html");
        }
        return extent;
    }

    // Create Extent Report Instance
    public static ExtentReports createInstance(String fileName) {
        ExtentSparkReporter spark = new ExtentSparkReporter(fileName);

        try {
            // Load from XML configuration
            spark.loadXMLConfig("src/test/resources/extent-config.xml");
        } catch (Exception e) {
            System.out.println("Extent config file not found, applying default settings.");
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("Automation Test Report");
            spark.config().setReportName("Selenium Test Execution");
        }

        extent = new ExtentReports();
        extent.attachReporter(spark);

        // Add environment details (optional but useful)
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("User", System.getProperty("user.name"));
        extent.setSystemInfo("Execution Date", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));

        return extent;
    }
}
