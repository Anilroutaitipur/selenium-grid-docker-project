package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GooglePage {
    WebDriver driver;

    By searchBox = By.name("q");

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.google.com");
    }

    public void search(String text) {
        driver.findElement(searchBox).sendKeys(text);
        driver.findElement(searchBox).submit();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
