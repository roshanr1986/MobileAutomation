package commonLibs.implementation;

import commonLibs.contracts.Itextbox;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;

public class textboxControl implements Itextbox {


    @Override
    public void setText(WebElement element, String text) throws Exception {
        element.sendKeys(text);
    }

    @Override
    public void clearText(WebElement element) throws Exception {
        element.clear();
    }
}
