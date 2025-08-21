package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchResultsPage;
import java.time.Duration;

public class StepDefinitions {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private SearchResultsPage searchResultsPage;

    @Given("I am on the OpenCart homepage")
    public void i_am_on_the_opencart_homepage() {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/");
        homePage = new HomePage(driver);
    }

    @When("I navigate to the Login page")
    public void i_navigate_to_the_login_page() {
        homePage.navigateToLoginPage();
        loginPage = new LoginPage(driver);
    }

    @When("I enter valid credentials {string} and {string}")
    public void i_enter_valid_credentials(String email, String password) {
        loginPage.login(email, password);
    }

    @Then("I should see the {string} page heading")
    public void i_should_see_the_page_heading(String expectedHeading) {
        String actualHeading = loginPage.getPageHeading();
        Assert.assertEquals(actualHeading, expectedHeading);
        driver.quit();
    }

    @When("I search for a product {string}")
    public void i_search_for_a_product(String product) {
        searchResultsPage = homePage.searchForProduct(product);
    }

    @Then("the search results should contain the product {string}")
    public void the_search_results_should_contain_the_product(String product) {
        boolean isProductFound = searchResultsPage.isProductInResults(product);
        Assert.assertTrue(isProductFound, "Product '" + product + "' not found in search results.");
        driver.quit();
    }

    @When("I click {string} for the {string}")
    public void i_click_add_to_cart_for_the(String button, String product) {
        if (button.equals("Add to Cart")) {
            searchResultsPage.addToCart(product);
        }
    }

    @Then("a success message {string} should be displayed")
    public void a_success_message_should_be_displayed(String expectedMessage) {
        String actualMessage = searchResultsPage.getSuccessMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage), "Success message not displayed or incorrect.");
        driver.quit();
    }
}