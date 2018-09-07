package commonLibs.implementation;

import commonLibs.contracts.Driver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class commonDriver implements Driver {

    private static AndroidDriver driver;;
    private long pageLoadTimeout;
    private long elementDetectionTimeout;

    public AndroidDriver getDriver() {
        return driver;
    }

    public void setPageLoadTimeout(long pageLoadTimeout) {

        this.pageLoadTimeout = pageLoadTimeout;
    }

    public void setElementDetectionTimeout(long elementDetectionTimeout) {
        this.elementDetectionTimeout = elementDetectionTimeout;
    }


    public commonDriver() throws MalformedURLException {

        URL url= new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(url,setAndroidCapabilities());

        //setting the values for waiting times
        pageLoadTimeout=201;
        elementDetectionTimeout=601;



    }

    @Override
    public DesiredCapabilities setAndroidCapabilities() {
        DesiredCapabilities capabilities=DesiredCapabilities.android();

        //set capability to run test on chrome browser
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
        //
        capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"My Device");

        capabilities.setCapability(MobileCapabilityType.VERSION,"4.4.2");

        capabilities.setCapability("appPackage","com.info.law.lawganizer");

        capabilities.setCapability("appActivity","com.info.law.lawganizer.Splash");

        return capabilities;
    }

    @Override
    public void openBrowserAndGetURL(String url) throws Exception {

        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);

        url=url.trim();
        driver.get(url);

    }

    @Override
    public String getTitle() throws Exception {
        return driver.getTitle();
    }

    @Override
    public String getCurrentURL() throws Exception {
        return driver.getCurrentUrl();
    }

    @Override
    public String getPageSource() throws Exception {
        return driver.getPageSource();
    }

    @Override
    public void navigateToURL(String url) throws Exception {
    url=url.trim();
    driver.navigate().to(url);
    }

    @Override
    public void navigateToForward() throws Exception {
    driver.navigate().forward();
    }

    @Override
    public void navigateToBackward() throws Exception {
    driver.navigate().back();
    }

    @Override
    public void refresh() throws Exception {
    driver.navigate().refresh();
    }

    @Override
    public void closeBrowser() throws Exception {
        driver.close();
    }

    @Override
    public void closeAllBrowsers() throws Exception {
        driver.quit();
    }

    @Override
    public void waitForElementPresent(WebDriver driver, WebElement element) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver,4000);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

}
