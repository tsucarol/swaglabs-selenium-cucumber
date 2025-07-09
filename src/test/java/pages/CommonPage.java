package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonPage {
    
    public WebDriver driver;

    @FindBy(css = "span.title") WebElement pageHeader;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
    }

    /* Common Functions */
    public String getTabTitle() {
        return driver.getTitle();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public String getHeader() {
        return pageHeader.getText();
    }
}
