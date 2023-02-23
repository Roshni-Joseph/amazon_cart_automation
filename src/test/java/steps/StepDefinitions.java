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
import pages.AddToCartButton;
import pages.IncrementQuantity;
import pages.Subtotal;
import utils.BrowserManager;
import utils.QaProps;
import utils.TestDataReader;

import java.util.HashMap;

public class StepDefinitions {

    private WebDriver driver;
    String url;
    AddToCartButton addToCartButton;
    Subtotal subtotal;

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
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("window.scrollBy(0,500)");
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


//    @Given("the user has an item in the cart")
//    public void the_user_has_an_item_in_the_cart() {
////        url= QaProps.getValue("url");
////        driver.get(url);
//
////        incrementQuantity = new IncrementQuantity(driver);
//
//
//
//    }
//    @When("the user increases the quantity to two")
//    public void the_user_increases_the_quantity_to_two() {
//
//    }
//    @Then("the price is doubled")
//    public void the_price_is_doubled() {
//
//    }



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
        Assert.assertEquals(totalAmt,"₹1,42,998.00");

    }


}
