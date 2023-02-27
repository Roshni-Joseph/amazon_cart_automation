package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScenarioOutline {
    private WebDriver driver;

    public ScenarioOutline(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id=\"twotabsearchtextbox\"]")
    WebElement searchBox;

    @FindBy(className = "a-color-state")
    WebElement item;


    public WebElement getSearchBox() {
        return searchBox;
    }

    public WebElement getItem() {
        return item;
    }
}
