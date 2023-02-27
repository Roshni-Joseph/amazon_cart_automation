package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartIconIsOne {
    private WebDriver driver;

    public CartIconIsOne(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "nav-cart-count")
    WebElement cartIconCount;

    @FindBy(xpath = "//a[@id=\"nav-cart\"]")
    WebElement tabcart;

    @FindBy(xpath = "//input[@id=\"twotabsearchtextbox\"]")
    WebElement searchBox;

//    @FindBy(xpath = "//input[@id=\"nav-search-submit-button\"]")
//    WebElement searchIcon;

    @FindBy(xpath = "(//span[@class=\"a-size-medium a-color-base a-text-normal\"])[1]")
    WebElement iphone;

    @FindBy(id = "add-to-cart-button")
    WebElement addToCartBtn;

//    @FindBy(xpath = "//div[@class=\"a-row sc-your-amazon-cart-is-empty\"]")
    WebElement cartIsEmpty;


    public WebElement getCartIconCount() {
        return cartIconCount;
    }

    public WebElement getTabcart() {
        return tabcart;
    }

//    public WebElement getCartIsEmpty() {
//        return cartIsEmpty;
//    }

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

}
