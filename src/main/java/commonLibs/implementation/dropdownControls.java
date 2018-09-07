package commonLibs.implementation;

import commonLibs.contracts.Idropdown;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class dropdownControls implements Idropdown {

    private Select getDropdown(WebElement element){
        Select dropdown = new Select(element);
        return dropdown;
    }

    @Override
    public void selectByVisibleText(WebElement element, String visibleText) throws Exception {
    getDropdown(element).selectByVisibleText(visibleText);

    }

    @Override
    public void selectByValue(WebElement element, String value) throws Exception {
    getDropdown(element).selectByValue(value);
    }

    @Override
    public void selectByIndex(WebElement element, int index) throws Exception {
    getDropdown(element).selectByIndex(index);
    }

    @Override
    public boolean isMultiple(WebElement element) throws Exception {

        return getDropdown(element).isMultiple();
    }

    @Override
    public List<WebElement> getAllOptions(WebElement element) throws Exception {
        return getDropdown(element).getOptions();
    }

    @Override
    public List<WebElement> getAllSelectedOptions(WebElement element) throws Exception {
        return getDropdown(element).getAllSelectedOptions();
    }

    @Override
    public WebElement getFirstSelectedOption(WebElement element) throws Exception {
        return getDropdown(element).getFirstSelectedOption();
    }

    @Override
    public String getSelectedItemName(WebElement element) throws Exception {
        return getDropdown(element).getFirstSelectedOption().getText();
    }
}
