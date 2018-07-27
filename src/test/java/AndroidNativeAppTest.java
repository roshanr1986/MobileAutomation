import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Alert;
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
import java.util.concurrent.TimeUnit;

public class AndroidNativeAppTest {

    private static AndroidDriver driver;

    @Test
    public void RunAndroidTestApp() throws MalformedURLException, InterruptedException {


        DesiredCapabilities capabilities=DesiredCapabilities.android();

        //set capability to run test on chrome browser
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
        //
        capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"My Device");

        capabilities.setCapability(MobileCapabilityType.VERSION,"4.4.2");

        capabilities.setCapability("appPackage","io.selendroid.testapp");

        capabilities.setCapability("appActivity","io.selendroid.testapp.HomeScreenActivity");

        URL url= new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(url,capabilities);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement
                (By.xpath("//android.widget.EditText[@content-desc=\'my_text_fieldCD\']"))
                .sendKeys("Roshan Ranasinghe");

        driver.findElement(By.id("io.selendroid.testapp:id/buttonTest")).click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);



        //Alert popupAlert= driver.switchTo().alert();
        driver.findElement(By.id("android:id/button2")).click();

        Thread.sleep(5000);
        driver.quit();




    }
}
