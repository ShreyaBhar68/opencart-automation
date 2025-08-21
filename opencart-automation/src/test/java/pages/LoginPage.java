package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By emailField = By.id("input-email");
    private By passwordField = By.id("input-password");
    private By loginButton = By.cssSelector("input[value='Login']");
    private By pageHeading = By.cssSelector("#content h2");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String getPageHeading() {
        return driver.findElement(pageHeading).getText();
    }
}