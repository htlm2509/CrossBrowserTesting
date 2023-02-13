package cucumber.steps;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseSteps {

    SoftAssertions softAssertions = new SoftAssertions();

    public static WebDriver getWebDriverInstance(String driverName) {

        switch (driverName.toLowerCase()) {
            case "firefox":
               return setFirefoxInstance();
            case "chrome":
               return setChromeInstance();
            default:
                throw new IllegalArgumentException("Driver is not supported");
        }
    }

    private static WebDriver setChromeInstance() {
        ChromeOptions chromeOptions = new ChromeOptions()
                .addArguments("--disable-extensions", "--disable-dev-shm-usage", "--no-sandbox");
        chromeOptions.setCapability("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        return new ChromeDriver(chromeOptions);
    }

    private static WebDriver setFirefoxInstance() {
        FirefoxOptions firefoxOptions = new FirefoxOptions()
                .addArguments("--disable-extensions", "--disable-dev-shm-usage", "--no-sandbox");
        firefoxOptions.setCapability("webdriver.firefox.driver", "src/test/resources/geckodriver.exe");
        return new FirefoxDriver(firefoxOptions);
    }

    public void waitUntilElementIsClickable(WebElement webElement, WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
