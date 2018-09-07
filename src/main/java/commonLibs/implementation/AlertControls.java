package commonLibs.implementation;

import commonLibs.contracts.IalertHandeling;
import org.openqa.selenium.WebDriver;

public class AlertControls implements IalertHandeling {

    private WebDriver driver;
    public AlertControls(WebDriver driver){

        this.driver=driver;

    }


    @Override
    public void acceptAlert() throws Exception {
    driver.switchTo().alert().accept();
    }

    @Override
    public void rejectAlert() throws Exception {
    driver.switchTo().alert().dismiss();
    }

    @Override
    public String getMessageOfAlert() throws Exception {
        return driver.switchTo().alert().getText();
    }

    @Override
    public boolean isAlertPresent(int timeoutInSeconds) throws Exception {
        return false;
    }
}
