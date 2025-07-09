package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends CommonPage {
    public CartPage (WebDriver driver) {
        super (driver);
        PageFactory.initElements(driver, this);
    }
}
