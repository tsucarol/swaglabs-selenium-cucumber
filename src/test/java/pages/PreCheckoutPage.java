package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PreCheckoutPage extends CommonPage {
    public PreCheckoutPage (WebDriver driver) {
        super (driver);
        PageFactory.initElements(driver, this);
    }

    /* Mapping */
    @FindBy(id = "first-name") WebElement firstNameInput;
    @FindBy(id = "last-name") WebElement lastNameInput;
    @FindBy(id = "postal-code") WebElement postalCodeInput;
    @FindBy(id = "continue") WebElement continueBtn;

    /* Actions */
    public void accessPreCheckoutPage(String url) {
        driver.get(url);
    }

    public void fillInformations(String firstName, String lastName, String postalCode) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        postalCodeInput.sendKeys(postalCode);
    }

    public void clickBtnContinue() {
        continueBtn.click();
    }
}
