import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LawTest_FirstTest {



    @Test
    public void TestLogin() throws MalformedURLException, InterruptedException, AWTException {


            //initializing the object repo object to acceess all objects
            ObjectRepo data= new ObjectRepo();

            //initializing the Functions object
            Functions function = new Functions();


        URL url = new URL(data.url);

        //capturing the returned capabilities from the setAndroidCapabilities class (to be passed onto driver)
        DesiredCapabilities capabilities=function.setAndroidCapabilities();

        AndroidDriver driver = new AndroidDriver(url,capabilities);

        //initializing wait object to set explicit wait
         WebDriverWait wait=new WebDriverWait(driver,15);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //waiting for email text box to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(data.email_id)));

        //login to the system
        function.login(driver,data.username,data.password,wait);

        //open hamberger menu
        function.openHamMenu(driver,wait);

        //extracting the displayed email address
        String actualEmail=driver.findElement(By.id(data.usereEmail_id)).getText().toString();

        //assert if username is equal to provided email address
        Assert.assertEquals(actualEmail,data.username);

       // Thread.sleep(5000);
        driver.quit();

    }



}
