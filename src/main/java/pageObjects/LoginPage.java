package pageObjects;

import commonLibs.implementation.commonDriver;
import commonLibs.implementation.commonElements;
import commonLibs.implementation.textboxControl;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.concurrent.TimeUnit;


public class LoginPage {

    public AndroidDriver driver;

    //defining web elements

    @FindBy(id = "com.info.law.lawganizer:id/email")
    private WebElement emailTextBox;

    @FindBy(id = "com.info.law.lawganizer:id/password")
    private WebElement passwordTextBox;

    @FindBy(id = "com.info.law.lawganizer:id/btnLogin")
    private WebElement loginBtn;

    @FindBy(id = "com.info.law.lawganizer:id/forgotPasswordLink")
    private WebElement forgotPasswordLink;


    //object declarations
    public commonElements comElements;
    public textboxControl textbox;


    public LoginPage(AndroidDriver driver) {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS),this);
        comElements = new commonElements(driver);
        textbox = new textboxControl();
    }

    // All functions of Login page

    public void login(String username, String password) throws Exception{

        try {
            textbox.setText(emailTextBox,username);
            textbox.setText(passwordTextBox,password);
            comElements.clickOnKeyboardReturnBtn(driver);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            comElements.click(loginBtn);
        }

    }



}
