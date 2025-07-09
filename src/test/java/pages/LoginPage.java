package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonPage {
    public LoginPage(WebDriver driver) {
        super (driver);
        PageFactory.initElements(driver, this);
    }

    /* Mapping */
    @FindBy(id = "user-name") WebElement usernameField;
    @FindBy(id = "password") WebElement passwordField;
    @FindBy(name = "login-button") WebElement loginBtn;
    @FindBy (css = "[data-test='error']") WebElement errorMessage;

    /* Actions */
    public void accessLoginPage(String url) {
        driver.get(url);
    }

    public void fillUsernamePassword(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    public void clickBtnLogin() {
        loginBtn.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
