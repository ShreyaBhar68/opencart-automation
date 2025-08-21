package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By myAccountDropdown = By.cssSelector("#top-links .fa-user");
    private By loginLink = By.linkText("Login");
    private By searchBox = By.name("search");
    private By searchButton = By.cssSelector("#search button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLoginPage() {
        driver.findElement(myAccountDropdown).click();
        driver.findElement(loginLink).click();
    }

    public SearchResultsPage searchForProduct(String product) {
        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchButton).click();
        return new SearchResultsPage(driver);
    }
}
