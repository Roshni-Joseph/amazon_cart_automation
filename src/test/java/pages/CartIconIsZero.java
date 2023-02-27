package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartIconIsZero {
    private WebDriver driver;

    public CartIconIsZero(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "nav-cart-count")
    WebElement cartIconCount;

    @FindBy(xpath = "//a[@id=\"nav-cart\"]")
    WebElement tabcart;

    @FindBy(xpath = "//div[@class=\"a-row sc-your-amazon-cart-is-empty\"]")
    WebElement cartIsEmpty;


    public WebElement getCartIconCount() {
        return cartIconCount;
    }

    public WebElement getTabcart() {
        return tabcart;
    }

    public WebElement getCartIsEmpty() {
        return cartIsEmpty;
    }
}
