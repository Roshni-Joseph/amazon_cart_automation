package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteFromCart {
    private WebDriver driver;

    public DeleteFromCart(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id=\"twotabsearchtextbox\"]")
    WebElement searchBox;

    @FindBy(xpath = "(//span[@class=\"a-size-medium a-color-base a-text-normal\"])[1]")
    WebElement iphone;

    @FindBy(id = "add-to-cart-button")
    WebElement addToCartBtn;

    @FindBy(xpath = "//a[@id=\"nav-cart\"]")
    WebElement tabcart;

    @FindBy(xpath = "(//input[@class=\"a-color-link\"])[1]")
    WebElement deleteBtn;

    @FindBy(xpath = "//h1[@class=\"a-spacing-mini a-spacing-top-base\"]")
    WebElement cartIsEmpty;

    public WebElement getSearchBox() {
        return searchBox;
    }

    public WebElement getIphone() {
        return iphone;
    }

    public WebElement getAddToCartBtn() {
        return addToCartBtn;
    }

    public WebElement getTabcart() {
        return tabcart;
    }

    public WebElement getDeleteBtn() {
        return deleteBtn;
    }

    public WebElement getCartIsEmpty() {
        return cartIsEmpty;
    }
}
