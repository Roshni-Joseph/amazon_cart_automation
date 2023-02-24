package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FailedTestCase {
    private WebDriver driver;

    public FailedTestCase(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id=\"twotabsearchtextbox\"]")
    WebElement searchBox;


    @FindBy(xpath = "(//span[@class=\"a-size-medium a-color-base a-text-normal\"])[1]")
    WebElement iphone;

    @FindBy(id = "add-to-cart-button")
    WebElement addToCartBtn;


    public WebElement getSearchBox() {
        return searchBox;
    }


    public WebElement getIphone() {
        return iphone;
    }

    public WebElement getAddToCartBtn() {
        return addToCartBtn;
    }


}
