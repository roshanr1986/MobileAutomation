package commonLibs.contracts;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface IcommonElements {

    public String getText(WebElement element) throws Exception;

    public String getExtractedText(String text) throws Exception;

    public void click(WebElement element) throws Exception;

    public String getAttribute(WebElement element, String attribute) throws Exception;

    public String getCssValue(WebElement element, String cssPropertyName) throws Exception;

    public boolean isElementEnabled(WebElement element) throws Exception;

    public boolean isElementVisible(WebElement element) throws Exception;

    public boolean isElementSelected(WebElement element) throws Exception;

    public WebElement getElementByXpath(AndroidDriver driver, String xpathExpression) throws Exception;

    public List<WebElement> getElementsByXpath(AndroidDriver driver, String xpathExpression) throws Exception;

    public void waitForElementToBeClickable(AndroidDriver driver, WebElement element) throws Exception;

    public void clickOnKeyboardReturnBtn(AndroidDriver driver) throws Exception;

}
