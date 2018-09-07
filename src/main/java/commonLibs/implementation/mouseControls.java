package commonLibs.implementation;

import commonLibs.contracts.ImouseOperation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class mouseControls implements ImouseOperation {

    private WebDriver driver;
    public mouseControls(WebDriver driver) {
    this.driver=driver;
    }

    private Actions getAction(){
        Actions action = new Actions(driver);
        return action;
    }

    @Override
    public void dragAndDrop(WebElement element1, WebElement element2) throws Exception {
        getAction().dragAndDrop(element1,element2).build().perform();
    }

    @Override
    public void moveToElement(WebElement element) throws Exception {
        getAction().moveToElement(element).build().perform();
    }


    @Override
    public void rightClick(WebElement element) throws Exception {
        getAction().contextClick(element).build().perform();
    }

    @Override
    public void doubleClick(WebElement element) throws Exception {
        getAction().doubleClick(element).build().perform();
    }

    @Override
    public void moveToElementAndClick(WebElement element) throws Exception {
        getAction().moveToElement(element).click(element).build().perform();

    }
}
