package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserManager;

public class AddToCartButton {

    private WebDriver driver;

    public AddToCartButton(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id=\"twotabsearchtextbox\"]")
    WebElement searchBox;

//    @FindBy(xpath = "//input[@id=\"nav-search-submit-button\"]")
//    WebElement searchIcon;

    @FindBy(xpath = "(//span[@class=\"a-size-medium a-color-base a-text-normal\"])[1]")
    WebElement iphone;

    @FindBy(id = "add-to-cart-button")
    WebElement addToCartBtn;

    @FindBy(xpath = "//span[@class=\"a-size-medium-plus a-color-base sw-atc-text a-text-bold\"]")
    WebElement addedToCart;

    public WebElement getSearchBox() {
        return searchBox;
    }

//    public WebElement getSearchIcon() {
//        return searchIcon;
//    }

    public WebElement getIphone() {
        return iphone;
    }

    public WebElement getAddToCartBtn() {
        return addToCartBtn;
    }

    public WebElement getAddedToCart() {
        return addedToCart;
    }
}
