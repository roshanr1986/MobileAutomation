package commonLibs.contracts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public interface Idropdown {

    public void selectByVisibleText(WebElement element, String visibleText) throws Exception;
    public void selectByValue(WebElement element, String value) throws Exception;
    public void selectByIndex(WebElement element, int index) throws Exception;
    public boolean isMultiple(WebElement element) throws Exception;
    public List<WebElement> getAllOptions(WebElement element) throws Exception;
    public List<WebElement> getAllSelectedOptions(WebElement element) throws Exception;
    public WebElement getFirstSelectedOption(WebElement element)throws Exception;
    public String getSelectedItemName(WebElement element)throws Exception;
}
