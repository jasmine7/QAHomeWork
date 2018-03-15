package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseFunctions {

    WebDriver driver;
    private static final String CHROME_DRIVER_LOCATION = "/Users/svetlana/Documents/chromedriver";
    private static final Logger LOGGER = LogManager.getLogger(BaseFunctions.class);

    public BaseFunctions() {

        LOGGER.info("Setting chromedriver location: " + CHROME_DRIVER_LOCATION);
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_LOCATION);

        LOGGER.info("Starting chromedriver.");
        this.driver = new ChromeDriver();


    }

}
