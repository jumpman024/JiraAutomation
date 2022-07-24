package uiUtils.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import readProperties.ConfigProvider;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

abstract public class BaseSeleniumTest {
    public WebDriver driver;


    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("103.0");
//        capabilities.setPlatform(Platform.LINUX);
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        capabilities.setCapability("videoName", "new_video.mp4");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // execute tests in browser local
        driver.get(ConfigProvider.URL);
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        try {
//            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
//                    capabilities);
//            driver.get(ConfigProvider.URL);
//            System.out.println(driver.getTitle());
//                    driver = new ChromeDriver();
//            driver.manage().window().maximize();
//            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            BaseSeleniumPage.setDriver(driver);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }


    }

    @AfterMethod
    public void tearDown() {
//        driver.close();
//        driver.quit();
    }


//    @Test
//    public void test1() throws MalformedURLException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setBrowserName("chrome");
//        capabilities.setVersion("103.0");
//        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enableVideo", true);
//        capabilities.setCapability("videoName", "new_video.mp4");
//        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
//                capabilities);
//        driver.get("https://www.google.com/");
//        driver.quit();

//    @Test(dataProvider = "getData")
//    public void runTestInDocker(String browser,String version,String value) throws Exception {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//
//        capabilities.setBrowserName(browser);
//        capabilities.setVersion(version);
//        capabilities.setPlatform(Platform.ANY);
//        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enableVideo", true);
//        capabilities.setCapability("videoName", browser+version+value);
//                WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
//                capabilities);
//        WebDriver driver2 = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
//                capabilities);
//        driver.get("https://www.bbc.com/");
//        driver2.get("https://www.bbc.com/");
//        System.out.println(driver.getTitle());
//        Thread.sleep(15000);
//        driver.quit();
//        driver2.quit();
//    }
//
//
//
//    @DataProvider(parallel = true)
//    public Object[][] getData(){
//
//        return new String[][]{
//                {"chrome","103.0","selenium"},
//                {"chrome","102.0","selenium"}
//        };
//    }

    }
