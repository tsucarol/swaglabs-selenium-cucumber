package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage extends CommonPage {
    public InventoryPage (WebDriver driver) {
        super (driver);
        PageFactory.initElements(driver, this);
    }

    /* Mapping */
    @FindBy(className = "shopping_cart_badge") WebElement cartCounter;
    @FindBy(id = "react-burger-menu-btn") WebElement menuBtn;
    @FindBy(id = "reset_sidebar_link") WebElement resetAppStateLink;

    private By btnByProduct(String productName) {
        String product = productName.toLowerCase().replace(" ", "-");
        return By.cssSelector("[data-test='add-to-cart-" + product + "'], [data-test='remove-" + product + "']");
    }

    /* Actions */
    public void accessInventoryPage(String url) {
        driver.get(url);
    }

    public void addProductToCart(String productName) {
        driver.findElement(btnByProduct(productName)).click();
    }

    public void clickBtnCart() {
        cartCounter.click();
    }

    public String getBtnProductState(String productName) {
        return driver.findElement(btnByProduct(productName)).getText();
    }

    public String getCartItemCount() {
        try {
            return cartCounter.getText();
        } catch (Exception e) {
            return "0";
        }
    }

    public void resetAppState() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        menuBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(resetAppStateLink));
        resetAppStateLink.click();
        driver.navigate().refresh();
    }
}
