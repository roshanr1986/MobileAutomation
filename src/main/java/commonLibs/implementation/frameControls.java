package commonLibs.implementation;

import commonLibs.contracts.IframeHandeling;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class frameControls implements IframeHandeling {

    private WebDriver driver;
    public frameControls(WebDriver driver) {
        this.driver=driver;
    }


    @Override
    public void switchToFrame(String frameID) throws Exception {
        driver.switchTo().frame(frameID);
    }

    @Override
    public void switchToFrame(WebElement element) throws Exception {
        driver.switchTo().frame(element);
    }

    @Override
    public void switchToFrame(int index) throws Exception {
        driver.switchTo().frame(index);
    }

    @Override
    public void switchToDefaultContent() throws Exception {
        driver.switchTo().defaultContent();

    }
}
