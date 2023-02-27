package utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class ClickUtils {
    public static void click(WebDriver driver, WebElement element){
        WaitUtils.waitTillVisible(driver,element);
        element.click();
    }
}