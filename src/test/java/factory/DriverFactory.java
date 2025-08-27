package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.Properties;
import java.io.FileInputStream;

public class DriverFactory {

    private static WebDriver driver;
    private static Properties prop;

    public static WebDriver initDriver() {
        try {
            // Load config
            prop = new Properties();
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            prop.load(fis);

            String browser = prop.getProperty("browser").toLowerCase();
            String gridUrl = prop.getProperty("grid.url");

            switch (browser) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    driver = new RemoteWebDriver(new URL(gridUrl), chromeOptions);
                    break;

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    driver = new RemoteWebDriver(new URL(gridUrl), firefoxOptions);
                    break;

                default:
                    throw new IllegalArgumentException("Browser not supported: " + browser);
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}

