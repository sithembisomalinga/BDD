package StepDefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Constants {
    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver objDriver) {
        this.driver = objDriver;
    }

    public WebDriver initializeWebDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }
}
