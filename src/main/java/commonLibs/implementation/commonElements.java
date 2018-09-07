package commonLibs.implementation;

import commonLibs.contracts.IcommonElements;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class commonElements implements IcommonElements {

    private AndroidDriver driver;

    public commonElements(AndroidDriver driver) {
        this.driver=driver;

    }

    @Override
    public String getText(WebElement element) throws Exception {
        return element.getText();
    }

    @Override
    public String getExtractedText(String branchAddressExtractedText) throws Exception {
        return branchAddressExtractedText.trim().toString();

    }


    public List<WebElement> getElementsByTagName(WebElement parentElement,String tagName) throws Exception {
        List<WebElement> elements = parentElement.findElements(By.tagName(tagName));
       return elements;
    }


    @Override
    public void click(WebElement element) throws Exception {
    element.click();
    }

    @Override
    public String getAttribute(WebElement element, String attribute) throws Exception {
        return element.getAttribute(attribute);
    }

    @Override
    public String getCssValue(WebElement element, String cssPropertyName) throws Exception {
        return element.getCssValue(cssPropertyName);
    }

    @Override
    public boolean isElementEnabled(WebElement element) throws Exception {
        return element.isEnabled();
    }

    @Override
    public boolean isElementVisible(WebElement element) throws Exception {
        return element.isDisplayed();
    }

    @Override
    public boolean isElementSelected(WebElement element) throws Exception {
        return element.isSelected();
    }

    @Override
    public WebElement getElementByXpath(AndroidDriver driver, String xpathExpression) throws Exception {
        return null;
    }

    @Override
    public List<WebElement> getElementsByXpath(AndroidDriver driver, String xpathExpression) throws Exception {
        return null;
    }

    @Override
    public void waitForElementToBeClickable(AndroidDriver driver, WebElement element) throws Exception {

    }

    @Override
    public void clickOnKeyboardReturnBtn(AndroidDriver driver) throws Exception {
        (new TouchAction(driver)).tap(1009, 1862).perform();
    }
}
