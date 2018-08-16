import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class Startchrome {

    @Test
    public void test1() throws MalformedURLException{



        DesiredCapabilities capabilities=DesiredCapabilities.android();

        //set capability to run test on chrome browser
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
        //
        capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"My Device");

        capabilities.setCapability(MobileCapabilityType.VERSION,"4.4.2");

        URL url= new URL("http://127.0.0.1:4723/wd/hub");

        WebDriver driver = new AndroidDriver(url,capabilities);
        WebDriverWait wait = new WebDriverWait(driver, 10);


        driver.get("https://www.xe.com/currencyconverter/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount")));
        driver.findElement(By.id("amount")).click();
        driver.findElement(By.id("amount")).sendKeys("5");
        driver.findElement(By.id("ucc_go_btn_svg")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'ucc-container\']/span[2]/span[2]")));

        String result=driver.findElement(By.xpath("//*[@id=\'ucc-container\']/span[2]/span[2]")).getText();


        Assert.assertEquals(result,"4.33320");





    }
}
