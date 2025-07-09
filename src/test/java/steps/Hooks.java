package steps;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Base;
import pages.LoginPage;

public class Hooks {
    Base base;
    private LoginPage loginPage;

    public Hooks(Base base) {
        this.base = base;
    }

    @Before
    public void init() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--window-size=1920,1080");

        base.driver = new ChromeDriver(options);
        base.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(60000)); // 1 min
    }

    @Before("@cart")
    public void loginBeforeCart() {
        loginPage = new LoginPage(base.driver);
        loginPage.accessLoginPage("https://www.saucedemo.com/");
        loginPage.fillUsernamePassword("standard_user", "secret_sauce");
        loginPage.clickBtnLogin();
    }

    @After
    public void finish() {
        base.driver.quit();
    }
}
