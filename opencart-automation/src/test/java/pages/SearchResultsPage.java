package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SearchResultsPage {
    private WebDriver driver;

    private By successMessage = By.cssSelector(".alert.alert-success");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductInResults(String product) {
        WebElement productLink = driver.findElement(By.linkText(product));
        return productLink.isDisplayed();
    }

    public void addToCart(String product) {
        driver.findElement(By.xpath("//div[contains(@class, 'product-layout')][.//a[text()='" + product + "']]//button[contains(@onclick, 'cart.add')]")).click();
    }

    public String getSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return successAlert.getText();
    }
}