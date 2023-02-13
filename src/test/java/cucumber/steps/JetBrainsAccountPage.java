package cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class JetBrainsAccountPage extends BaseSteps {

    private WebDriver driver;

    @Before
    public void setUpTest() {
        driver = getWebDriverInstance(System.getProperty("browser"));
        driver.manage().window().maximize();
    }

    @When("I open the JetBrains home page")
    public void openJetBrainsHomePage() {
        driver.get("https://www.jetbrains.com/idea/");
    }


    @And("I click Account button")
    public void clickDownloadButton() {
        WebElement accountButton = driver.findElement(By
                .xpath("//a[@data-test='site-header-profile-action']"));
        waitUntilElementIsClickable(accountButton, driver);
        accountButton.click();
    }

    @Then("JetBrains Account page is opened")
    public void jetBrainsAccountPageIsOpened() {
        assertThat(driver.getTitle())
                .as("Wrong page is opened")
                .isEqualTo("JetBrains Account");
        softAssertions.assertAll();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
