package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Subtotal {

    private WebDriver driver;

    public Subtotal(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id=\"twotabsearchtextbox\"]")
    WebElement searchBox;

    @FindBy(xpath = "(//span[@class=\"a-size-medium a-color-base a-text-normal\"])[1]")
    WebElement iphone;

    @FindBy(id = "add-to-cart-button")
    WebElement addToCartBtn;

    @FindBy(xpath = "(//span[@class=\"a-size-medium a-color-base a-text-normal\"])[2]")
    WebElement iphone2;

    @FindBy(xpath = "(//input[@class=\"a-button-input\"])[25]")
    WebElement cart;

    @FindBy(id = "attach-accessory-cart-subtotal")
    WebElement totalPrice;

    public WebElement getSearchBox() {
        return searchBox;
    }

    public WebElement getIphone() {
        return iphone;
    }

    public WebElement getAddToCartBtn() {
        return addToCartBtn;
    }

    public WebElement getIphone2() {
        return iphone2;
    }

    public WebElement getCart() {
        return cart;
    }

    public WebElement getTotalPrice() {
        return totalPrice;
    }
}
