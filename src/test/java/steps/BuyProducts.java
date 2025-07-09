package steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.InventoryPage;
import pages.Base;

public class BuyProducts {
    final WebDriver driver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    public String username;
    public String password;

    public BuyProducts(Base base) {
        this.driver = base.driver;
    }

    /* LOGIN TESTS */
    @Given("I am on the login page {string}")
    public void i_am_on_the_login_page(String url) {
        loginPage = new LoginPage(driver);
        loginPage.accessLoginPage(url);

        assertEquals("Swag Labs", loginPage.getTabTitle());
    }

    @When("I enter {string} and {string}")
    public void i_enter_and(String username, String password) {
        this.username = username;
        this.password = password;
        loginPage.fillUsernamePassword(username, password);
    }

    @When("I click the Login button")
    public void i_click_the__login_button() {
        loginPage.clickBtnLogin();
        inventoryPage = new InventoryPage(driver);
    }

    @Then("I should be redirected to the inventory page")
    public void i_should_be_redirected_to_the_inventory_page() {
        assertEquals("https://www.saucedemo.com/inventory.html", loginPage.getUrl());
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String error_message) {
        assertEquals(error_message, loginPage.getErrorMessage());
    }

    /* CART TESTS */
    @Given("I am on the inventory page {string}")
    public void i_am_on_the_inventory_page(String url) {
        inventoryPage = new InventoryPage(driver);
        inventoryPage.accessInventoryPage(url);

        assertEquals("Swag Labs", inventoryPage.getTabTitle());
        assertEquals("Products", inventoryPage.getHeader());
        assertEquals("https://www.saucedemo.com/inventory.html", inventoryPage.getUrl());
    }

    @And("I reset the app state")
    public void i_reset_the_app_state() {
        inventoryPage.resetAppState();
    }

    @When("I click Add to cart for the product {string}")
    public void i_click_add_to_cart_for_the_product(String product) {
        inventoryPage.addProductToCart(product);
    }

    @Then("the button for {string} should change to Remove")
    public void the_button_for_should_change_to(String product) {
        assertEquals("Remove", inventoryPage.getBtnProductState(product));
    }

    @And("the cart counter should show {string} item\\(s)")
    public void the_cart_counter_should_show_item_s(String expected_count) {
        assertEquals(expected_count, inventoryPage.getCartItemCount());
    }

    
    @Given("I am on the cart page {string}")
    public void i_am_on_the_cart_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I click Checkout button")
    public void i_click_checkout_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I should be redirected to the checkout page")
    public void i_should_be_redirected_to_the_checkout_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    /* CHECKOUT TESTS */
}
