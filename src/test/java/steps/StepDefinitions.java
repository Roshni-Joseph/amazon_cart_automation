package steps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.*;
import utils.BrowserManager;
import utils.QaProps;
import utils.TestDataReader;
import utils.WaitUtils;

import java.util.HashMap;

public class StepDefinitions {

    private WebDriver driver;
    String url;
    AddToCartButton addToCartButton;
    Subtotal subtotal;
    DeleteFromCart deleteFromCart;
    NegativeScenario negativeScenario;
    ScenarioOutline scenarioOutline;
    FailedTestCase failedTestCase;
    CartIconIsOne cartIconIsOne;
    CartIconIsZero cartIconIsZero;
    HashMap<String,String> data;
    Scenario scenario;

    public StepDefinitions(BrowserManager browserManager){
        this.driver = browserManager.getDriver();
    }
    @Before(order = 1)
    public void before(Scenario scenario){
        this.scenario = scenario;
    }


//AddToCart
    @Given("the user selects the item")
    public void the_user_select_the_item() {
        url= QaProps.getValue("url");
        driver.get(url);
    }
    @When("the user clicks add to cart button")
    public void the_user_clicks_add_to_cart_button() throws InterruptedException {
        addToCartButton = new AddToCartButton(driver);
        data= TestDataReader.getData(scenario.getName());
        addToCartButton.getSearchBox().sendKeys(data.get("Typevalue"));
        addToCartButton.getSearchBox().sendKeys(Keys.ENTER);
        addToCartButton.getIphone().click();
//        Thread.sleep(4000);
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        Actions actions = new Actions(driver);
        actions.moveToElement(addToCartButton.getAddToCartBtn()).perform();
//        Thread.sleep(4000);
        addToCartButton.getAddToCartBtn().click();
    }
    @Then("the item is added to cart")
    public void the_item_is_added_to_cart() throws InterruptedException {
        data= TestDataReader.getData(scenario.getName());
//        Thread.sleep(4000);
        WaitUtils.waitTillVisible(driver,addToCartButton.getAddedToCart());
        String text = addToCartButton.getAddedToCart().getText();
//        Thread.sleep(2000);
        Assert.assertEquals(text,data.get("Assertion"));

    }

//Subtotal
    @Given("the user navigate to amazon website")
    public void the_user_navigate_to_amazon_website() {
        url= QaProps.getValue("url");
        driver.get(url);
    }
    @When("the user selects the items and click add to cart button")
    public void the_user_selects_the_items_and_click_add_to_cart_button() throws InterruptedException {
        subtotal = new Subtotal(driver);
        data= TestDataReader.getData(scenario.getName());
        subtotal.getSearchBox().sendKeys(data.get("Typevalue"));
        subtotal.getSearchBox().sendKeys(Keys.ENTER);
//        Thread.sleep(2000);
        String winHandleBefore = driver.getWindowHandle();
        subtotal.getIphone().click();
//        Thread.sleep(2000);
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        Actions actions = new Actions(driver);
        actions.moveToElement(subtotal.getAddToCartBtn()).perform();
//        Thread.sleep(2000);
        subtotal.getAddToCartBtn().click();
        driver.switchTo().window(winHandleBefore);
        actions.moveToElement(subtotal.getIphone2()).perform();
//        Thread.sleep(2000);
        subtotal.getIphone2().click();
//        Thread.sleep(2000);
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        actions.moveToElement(subtotal.getAddToCartBtn()).perform();
//        Thread.sleep(2000);
        subtotal.getAddToCartBtn().click();
    }
    @Then("the items are added to cart and subtotal is shown")
    public void the_items_are_added_to_cart_and_subtotal_is_shown() throws InterruptedException {
        data= TestDataReader.getData(scenario.getName());
        WaitUtils.waitTillVisible(driver,subtotal.getTotalPrice());
        String totalAmt = subtotal.getTotalPrice().getText();
//        System.out.println(totalAmt);
//        Thread.sleep(4000);
        Assert.assertEquals(totalAmt,"₹1,11,800.00");

    }

//DeleteFromCart
    @Given("the cart contain two items")
    public void the_cart_contain_two_items() {
        url= QaProps.getValue("url");
        driver.get(url);
    }
    @When("the user clicks on delete button for first item")
    public void the_user_clicks_on_delete_button_for_first_item() throws InterruptedException {
        deleteFromCart = new DeleteFromCart(driver);
        String winHandleBefore = driver.getWindowHandle();
        data= TestDataReader.getData(scenario.getName());
        deleteFromCart.getSearchBox().sendKeys(data.get("Typevalue"));
        deleteFromCart.getSearchBox().sendKeys(Keys.ENTER);
        deleteFromCart.getIphone().click();
//        Thread.sleep(4000);
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        Actions actions = new Actions(driver);
        actions.moveToElement(deleteFromCart.getAddToCartBtn()).perform();
//        Thread.sleep(4000);
        deleteFromCart.getAddToCartBtn().click();
        WaitUtils.waitTillVisible(driver,deleteFromCart.getTabcart());
        driver.switchTo().window(winHandleBefore);
//        Alert alert= driver.switchTo(). alert();
        driver.navigate().refresh();
//
        WaitUtils.waitTillVisible(driver,deleteFromCart.getTabcart());
//
        deleteFromCart.getTabcart().click();
//        Thread.sleep(4000);
        WaitUtils.waitTillVisible(driver,deleteFromCart.getTabcart());
        deleteFromCart.getDeleteBtn().click();


    }
    @Then("the item is removed from cart and it is empty")
    public void the_item_is_removed_from_cart_and_it_is_empty() {
        data= TestDataReader.getData(scenario.getName());
//        Thread.sleep(4000);
        WaitUtils.waitTillVisible(driver,deleteFromCart.getTabcart());
        String totalAmt = deleteFromCart.getCartIsEmpty().getText();
//        Thread.sleep(4000);
        Assert.assertEquals(totalAmt,data.get("Assertion"));
    }

//NegativeScenario
    @Given("user navigate to amazon website")
    public void user_navigate_to_amazon_website() {
        url= QaProps.getValue("url");
        driver.get(url);
    }
    @When("the user search for invalid item name")
    public void the_user_search_for_invalid_item_name() {
        negativeScenario = new NegativeScenario(driver);
        data= TestDataReader.getData(scenario.getName());
        negativeScenario.getSearchBox().sendKeys(data.get("Typevalue"));
        negativeScenario.getSearchBox().sendKeys(Keys.ENTER);
    }
    @Then("{string} is displayed")
    public void is_displayed(String string) throws InterruptedException {
        data= TestDataReader.getData(scenario.getName());
        WaitUtils.waitTillVisible(driver,negativeScenario.getQqqq());
        String qqqq = negativeScenario.getQqqq().getText();
        System.out.println(qqqq);
//        Thread.sleep(4000);
        Assert.assertEquals(qqqq,data.get("Assertion"));
    }

//CartIconIsZero
    @When("the user clicks on cart icon")
    public void the_user_clicks_on_cart_icon() {
        cartIconIsZero = new CartIconIsZero(driver);
        String text = cartIconIsZero.getCartIconCount().getText();
        Assert.assertEquals(text,"0");
        cartIconIsZero.getTabcart().click();

    }
    @Then("the cart is empty and icon is zero")
    public void the_cart_is_empty_and_icon_is_zero() {
        data= TestDataReader.getData(scenario.getName());
        String text = cartIconIsZero.getCartIsEmpty().getText();
//        Thread.sleep(4000);
        Assert.assertEquals(text,data.get("Assertion"));
    }

//CartIconIsOne
    @When("the user selects the item and click add to cart button")
    public void the_user_selects_the_item_and_click_add_to_cart_button() {
        cartIconIsOne = new CartIconIsOne(driver);
        String winHandleBefore = driver.getWindowHandle();
        data= TestDataReader.getData(scenario.getName());
        cartIconIsOne.getSearchBox().sendKeys(data.get("Typevalue"));
        cartIconIsOne.getSearchBox().sendKeys(Keys.ENTER);
        cartIconIsOne.getIphone().click();
//        Thread.sleep(4000);
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        Actions actions = new Actions(driver);
        actions.moveToElement(cartIconIsOne.getAddToCartBtn()).perform();
//        Thread.sleep(4000);
        cartIconIsOne.getAddToCartBtn().click();
        driver.switchTo().window(winHandleBefore);
        driver.navigate().refresh();
        cartIconIsOne.getTabcart().click();



}
    @Then("the cart icon number is one")
    public void the_cart_icon_number_is_one() {
        String text = cartIconIsOne.getCartIconCount().getText();
        Assert.assertEquals(text,"1");

    }

//ScenarioOutline
    @Given("the user navigates to amazon website")
    public void the_user_navigates_to_amazon_website() {
        url= QaProps.getValue("url");
        driver.get(url);
    }
    @When("user search for product as {string}")
    public void user_search_for_products(String arg0) {
        scenarioOutline = new ScenarioOutline(driver);
        scenarioOutline.getSearchBox().sendKeys(arg0);
        scenarioOutline.getSearchBox().sendKeys(Keys.ENTER);
    }
    @Then("the products are displayed as {string}")
    public void theProductsAreDisplayedAs(String arg0) {
        WaitUtils.waitTillVisible(driver,scenarioOutline.getItem());
        String text = scenarioOutline.getItem().getText();
        Assert.assertEquals(text,arg0);
    }

//FailedTestcase
    @Given("user open amazon website")
    public void user_open_amazon_website() {
        url= QaProps.getValue("url");
        driver.get(url);
    }
    @When("the user add item to cart")
    public void the_user_add_item_to_cart() {

        failedTestCase = new FailedTestCase(driver);
        data= TestDataReader.getData(scenario.getName());
        failedTestCase.getSearchBox().sendKeys(data.get("Typevalue"));
        failedTestCase.getSearchBox().sendKeys(Keys.ENTER);
        failedTestCase.getIphone().click();
        failedTestCase.getAddToCartBtn().click();

    }


    @Then("the item is displayed in cart")
    public void theItemIsDisplayedInCart() {
    }
}
