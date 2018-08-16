import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.xml.xpath.XPathExpressionException;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LawSearchContacts {
     static AndroidDriver driver;


    @Test
    public void TestAddLawyer() throws AWTException, MalformedURLException, InterruptedException, XPathExpressionException {
//initializing the object repo object to acceess all objects
        ObjectRepo data= new ObjectRepo();

        //initializing the Functions object
        Functions function = new Functions();


        URL url = new URL(data.url);

        //capturing the returned capabilities from the setAndroidCapabilities class (to be passed onto driver)
        DesiredCapabilities capabilities=function.setAndroidCapabilities();

       AndroidDriver driver = new AndroidDriver(url,capabilities);
        //initializing wait object to set explicit wait
        WebDriverWait wait=new WebDriverWait(driver,25);


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //login
        function.login(driver,data.username,data.password,wait);

        //get searched contacts
       // List returnedvalues= new List();

        function.getSearchedContacts(driver,wait,"Malin");

        Thread.sleep(5000);
        driver.quit();

    }
}
