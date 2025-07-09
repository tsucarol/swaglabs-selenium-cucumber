package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PreCheckoutPage extends CommonPage {
    public PreCheckoutPage (WebDriver driver) {
        super (driver);
        PageFactory.initElements(driver, this);
    }
}
