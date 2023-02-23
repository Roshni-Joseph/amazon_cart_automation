package utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BrowserManager {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5,SECONDS);
    }
}
