package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends CommonPage {
    public CheckoutPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /* Mapping */

    /* Actions */
    public void accessCheckoutPage(String url) {
        driver.get(url);
    }
}
