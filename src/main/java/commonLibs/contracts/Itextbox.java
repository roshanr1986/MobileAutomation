package commonLibs.contracts;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;

public interface Itextbox {

    public void setText(WebElement element, String text) throws Exception;

    public void clearText(WebElement element) throws Exception;
}
