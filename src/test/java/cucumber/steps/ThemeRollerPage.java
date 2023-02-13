package cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class ThemeRollerPage extends BaseSteps {

    private WebDriver driver;

    @Before
    public void setUpTest() {
        driver = getWebDriverInstance(System.getProperty("browser"));
        driver.manage().window().maximize();
    }

    @Given("I am an anonymous customer with clear cookies")
    public void clearCookies() {
        driver.manage().deleteAllCookies();
    }

    @When("I open the jQuery home page")
    public void openFacebookHomePage() {
        driver.get("https://jqueryui.com/");
    }

    @And("I click Themes button")
    public void clickTermsAndConditionsLink() {
        WebElement termsAndConditionsLink = driver.findElement(By
                .xpath("//a[@href='https://jqueryui.com/themeroller/']"));
        waitUntilElementIsClickable(termsAndConditionsLink, driver);
        termsAndConditionsLink.click();
    }

    @Then("I am redirected to ThemeRoller page")
    public void verifyRedirectedToTermsAndConditionsPage() {
        assertThat(driver.getTitle())
                .as("Wrong page is opened")
                .isEqualTo("ThemeRoller | jQuery UI");
        softAssertions.assertAll();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
