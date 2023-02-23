package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BrowserManager;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Hooks {
    private BrowserManager browserManager;

    public Hooks(BrowserManager browserManager){
        this.browserManager = browserManager;
    }
    @Before(order = 0)
    public void setUp(){
        browserManager.setDriver();
    }
    @After(order = 0)
    public void tearDown(){
        browserManager.getDriver().quit();
    }

}
