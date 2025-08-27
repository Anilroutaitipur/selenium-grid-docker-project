package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public static void setup(String browser) throws Exception {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);

        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), options);

        } else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
