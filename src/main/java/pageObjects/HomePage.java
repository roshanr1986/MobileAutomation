package pageObjects;


import commonLibs.implementation.commonElements;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage {

    public AndroidDriver driver;


    //elements
    @FindBy(id = "com.info.law.lawganizer:id/menuBtn")
    private WebElement hamburgerMenuBtn;

    @FindBy(id = "com.info.law.lawganizer:id/tvEmail")
    private WebElement loggedInUserEmail;


    // declaration of objects
    public commonElements comElements;

    //constructor
    public HomePage(AndroidDriver driver) {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS),this);

        comElements = new commonElements(driver);

    }

    //methods
    public void closeHamburgerMenu(AndroidDriver driver)  {
        try {
            (new TouchAction(driver)).press(424 ,155).moveTo(139,155).release().perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openHamburgerMenu() throws Exception{
        try {
            comElements.click(hamburgerMenuBtn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getLoggedInUserEmail() throws Exception {
        return comElements.getText(loggedInUserEmail).trim();
    }


}
