import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.*;
import java.awt.*;

public class Functions {
    ObjectRepo data =new ObjectRepo();
    public DesiredCapabilities setAndroidCapabilities(){

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

    public void login(AndroidDriver driver, String username, String password, WebDriverWait wait)  {
        //this function just log user into the system


        //waiting for email text box to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(data.email_id)));

        //typing username and password
        driver.findElement(By.id(data.email_id)).sendKeys(username);
        driver.findElement(By.id(data.password_id)).sendKeys(password);

        (new TouchAction(driver)).tap(1009, 1862).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(data.loginBtn_id)));
        driver.findElement(By.id(data.loginBtn_id)).click();
    }

    public void openHamMenu(AndroidDriver driver, WebDriverWait wait){
        //this function opens the hamberger menu from anywhere in the application.

        //waiting for the hamburger menu to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(data.hamMenuBtn_id)));

        //click on hamberger button
        driver.findElement(By.id(data.hamMenuBtn_id)).click();

        //wait for user's email is visible to make sure hambergure menu is fully opened
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(data.usereEmail_id)));
    }

    public void closeHamMenu(AndroidDriver driver){

        (new TouchAction(driver)).press(424 ,155).moveTo(139,155).release().perform();
    }

    public void getSearchedContacts(AndroidDriver driver, WebDriverWait wait, String searchText) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(data.addContacts_id)));
        driver.findElement(By.id(data.addContacts_id)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(data.addContacts_lawyerTab_id)));
        driver.findElement(By.id(data.addContacts_lawyerTab_id)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(data.addContacts_addBtn_id)));
        driver.findElement(By.id(data.addContacts_addBtn_id)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(data.addContacts_searchBar)));
        driver.findElement(By.id(data.addContacts_searchBar)).sendKeys(searchText);

        //while the search results are not emoty, the loop will store all the contacts
        List searchedContacts= new List();
        int i=1;

        WebElement searchResult=new RemoteWebElement();
        searchResult=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget."+
                "LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget."+
                "LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget."+
                "LinearLayout/android.widget.ListView/android.widget.LinearLayout["+i+"]/android.widget.LinearLayout/android.widget."+
                "LinearLayout/android.widget.TextView[1]"));




        wait.until(ExpectedConditions.visibilityOf(searchResult));

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();

       // XPathExpression exper=xpath.compile("count(//android.widget.LinearLayout/android.widget.ListView[@resource-id='com.info.law.lawganizer:id/lawyerList']/android.widget.LinearLayout)");

       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout/android.widget.ListView[@resource-id='com.info.law.lawganizer:id/lawyerList']/android.widget.LinearLayout")));

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//android.widget.LinearLayout/android.widget.ListView[@resource-id='com.info.law.lawganizer:id/lawyerList']/android.widget.LinearLayout")));
        java.util.List<WebElement> resultCount = driver.findElements(By.xpath
           ("//android.widget.LinearLayout//android.widget.ListView[@resource-id='com.info.law.lawganizer:id/lawyerList']//android.widget.LinearLayout//android.widget.Button[@resource-id='com.info.law.lawganizer:id/sendBtn' and @text='Add']"));
      //  Number resultCount = (Number)exper.evaluate(driver,XPathConstants.NUMBER);

       System.out.println("=========== RESULT COUNT - "+resultCount.size() );

       /* while (searchResult.isDisplayed())
        {
            searchedContacts.add(searchResult.getText().toString(),i);
            i++;
            wait.until(ExpectedConditions.visibilityOf(searchResult));
            searchResult=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget."+
                    "LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget."+
                    "LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget."+
                    "LinearLayout/android.widget.ListView/android.widget.LinearLayout["+i+"]/android.widget.LinearLayout/android.widget."+
                    "LinearLayout/android.widget.TextView[1]"));
            System.out.println(searchResult.getText().toString());
        }*/



    }
}
