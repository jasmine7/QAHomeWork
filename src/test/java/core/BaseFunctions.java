package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseFunctions {

    WebDriver driver;
    private static final String CHROME_DRIVER_LOCATION = "/Users/svetlana/Documents/chromedriver";
    private static final Logger LOGGER = LogManager.getLogger(BaseFunctions.class);

    public BaseFunctions() {

        LOGGER.info("Setting chromedriver location: " + CHROME_DRIVER_LOCATION);
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_LOCATION);

        LOGGER.info("Starting chromedriver.");
        driver = new ChromeDriver();

        LOGGER.info("Browser is opening in full screen.");
        driver.manage().window().fullscreen();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void goToUrl(String url) {
        if(!url.contains("http://") && !url.contains("https://")) {
            url = "http://" + url;
        }
        driver.get(url);
    }

    public void closeBrowser() {
        LOGGER.info("Closing browser.");
        driver.quit();
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

}
