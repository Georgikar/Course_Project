package base;

import Driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestUtil {

    public WebDriver driver;
    private String applicationUrl, browser;


    @BeforeMethod
    public void setUp() {
        setupBrowserDriver();
        loadInitialPage();
    }

    private void loadInitialPage() {
        driver.get(applicationUrl);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }

    private void setupBrowserDriver() {
        try {
            FileInputStream configFile = new
                    FileInputStream("src/test/resources/config.properties");
            Properties config = new Properties();
            config.load(configFile);
            applicationUrl = config.getProperty("url");
            browser = config.getProperty("targetBrowser");

        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (browser) {
            case "chrome":
                driver = DriverFactory.getChromeDriver();
                break;
            case "firefox":
                driver = DriverFactory.getFireFoxDriver();
                break;
        }
    }
}


