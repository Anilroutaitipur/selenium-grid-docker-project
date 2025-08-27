package runners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Test {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Selenium Grid Docker");
        driver.findElement(By.name("q")).submit();
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Selenium"));
    }
}
