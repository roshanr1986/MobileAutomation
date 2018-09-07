import commonLibs.implementation.commonDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import java.net.MalformedURLException;

public class testLogin {
    public AndroidDriver driver;

    @Test
    public void testUserLogin() throws Exception {
        //creating required objects
        commonDriver comDriver = new commonDriver();

        ObjectRepo data = new ObjectRepo();

        //getting the created driver
        driver=comDriver.getDriver();

        //creating login page object by passing on the new driver with desired capabilities
        LoginPage login = new LoginPage(driver);

        //create homepage object
        HomePage home = new HomePage(driver);

        //log in with given creds
        login.login(data.username,data.password);

        //open hamburger menu
        home.openHamburgerMenu();

        //get logged in users email address
        String actualEmail = home.getLoggedInUserEmail();

        //assertion
        Assert.assertEquals(actualEmail,data.username);

        //close menu
        home.closeHamburgerMenu(driver);


       // comDriver.closeBrowser();
    }

}
