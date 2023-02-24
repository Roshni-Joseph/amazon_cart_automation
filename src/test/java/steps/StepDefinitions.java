package steps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.*;
import utils.BrowserManager;
import utils.QaProps;
import utils.TestDataReader;

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

    HashMap<String,String> data;
    Scenario scenario;
    public StepDefinitions(BrowserManager browserManager){
        this.driver = browserManager.getDriver();
    }

    @Before(order = 1)
    public void before(Scenario scenario){
        this.scenario = scenario;
    }
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
        Thread.sleep(4000);

        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        Actions actions = new Actions(driver);
        actions.moveToElement(addToCartButton.getAddToCartBtn()).perform();
        Thread.sleep(4000);
        addToCartButton.getAddToCartBtn().click();
//        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
//        Thread.sleep(2000);
//        addToCartButton.getAddToCartBtn().click();


    }
    @Then("the item is added to cart")
    public void the_item_is_added_to_cart() throws InterruptedException {
        Thread.sleep(20000);
        String text = addToCartButton.getAddedToCart().getText();
        Thread.sleep(2000);
        Assert.assertEquals(text,"Added to Cart");

    }


    @Given("the user has an item in the cart")
    public void the_user_has_an_item_in_the_cart() {
//        url= QaProps.getValue("url");
//        driver.get(url);

//        incrementQuantity = new IncrementQuantity(driver);



    }
    @When("the user increases the quantity to two")
    public void the_user_increases_the_quantity_to_two() {

    }
    @Then("the price is doubled")
    public void the_price_is_doubled() {


    }



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
        Thread.sleep(2000);
        String winHandleBefore = driver.getWindowHandle();
        subtotal.getIphone().click();
        Thread.sleep(2000);

        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        Actions actions = new Actions(driver);
        actions.moveToElement(subtotal.getAddToCartBtn()).perform();
        Thread.sleep(2000);
        subtotal.getAddToCartBtn().click();

        driver.switchTo().window(winHandleBefore);

//        for(String winHandle : driver.getWindowHandles()){
//            driver.switchTo().window(winHandle);
//        }

        actions.moveToElement(subtotal.getIphone2()).perform();
        Thread.sleep(2000);
        subtotal.getIphone2().click();
        Thread.sleep(2000);
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        actions.moveToElement(subtotal.getAddToCartBtn()).perform();
        Thread.sleep(2000);
        subtotal.getAddToCartBtn().click();
    }
    @Then("the items are added to cart and subtotal is shown")
    public void the_items_are_added_to_cart_and_subtotal_is_shown() throws InterruptedException {

        Thread.sleep(4000);
        String totalAmt = subtotal.getTotalPrice().getText();
        System.out.println(totalAmt);
        Thread.sleep(4000);
        Assert.assertEquals(totalAmt,"₹1,18,998.00");

    }

    @Given("the cart contain two items")
    public void the_cart_contain_two_items() {
        url= QaProps.getValue("url");
        driver.get(url);

    }
    @When("the user clicks on delete button for first item")
    public void the_user_clicks_on_delete_button_for_first_item() throws InterruptedException {
        deleteFromCart = new DeleteFromCart(driver);
        data= TestDataReader.getData(scenario.getName());
        deleteFromCart.getSearchBox().sendKeys(data.get("Typevalue"));
        deleteFromCart.getSearchBox().sendKeys(Keys.ENTER);
        deleteFromCart.getIphone().click();
        Thread.sleep(4000);
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("window.scrollBy(0,500)");
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        Actions actions = new Actions(driver);
        actions.moveToElement(deleteFromCart.getAddToCartBtn()).perform();
        Thread.sleep(4000);
        deleteFromCart.getAddToCartBtn().click();

    }
    @Then("the item is removed from cart and price is decreased")
    public void the_item_is_removed_from_cart_and_price_is_decreased() {

    }


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
    public void is_displayed(String string) {

    }


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
    @Then("the products are displayed")
    public void the_products_are_displayed() {

    }


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
    public void the_item_is_displayed_in_cart() {
        String text = addToCartButton.getAddedToCart().getText();
        Assert.assertEquals(text,"Added to Cart");


    }

}
