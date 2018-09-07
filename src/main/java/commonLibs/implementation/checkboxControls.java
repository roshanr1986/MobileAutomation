package commonLibs.implementation;

import commonLibs.contracts.Icheckbox;
import org.openqa.selenium.WebElement;

public class checkboxControls implements Icheckbox {
    @Override
    public void changeCheckboxStatus(WebElement element, boolean status) throws Exception {
        if ((element.isSelected() && !status) || (!element.isSelected() && status)){
            element.click();
        }
    }
}
