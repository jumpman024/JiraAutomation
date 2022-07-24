package uiUtils.core;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class SelenoidDriverProvider implements WebDriverProvider {


//    @BeforeTest
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("103.0");
        capabilities.setPlatform(Platform.LINUX);
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enable", true);
        capabilities.setCapability("videoName", "new_video");
//        browser.setCapability("screenResolution", "680x124x24"); // размер экрана

        try {
            RemoteWebDriver driver = new RemoteWebDriver(
                    new URL("http://localhost:4444/wd/hub"),
                    capabilities
            );
//            driver.manage().window().setSize(new Dimension(1280, 1024)); ставить в селениде
//            driver.manage().window().maximize();
            return driver;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
