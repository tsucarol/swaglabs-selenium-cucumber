package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends CommonPage {
    public CartPage (WebDriver driver) {
        super (driver);
        PageFactory.initElements(driver, this);
    }

    /* Mapping */
    @FindBy(id = "checkout") WebElement checkoutBtn;

    /* Actions */
    public void accessCartPage(String url) {
        driver.get(url);
    }

    public void clickBtnCheckout() {
        checkoutBtn.click();
    }
}
